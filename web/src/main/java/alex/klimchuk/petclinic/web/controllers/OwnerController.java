package alex.klimchuk.petclinic.web.controllers;

import alex.klimchuk.petclinic.data.model.Owner;
import alex.klimchuk.petclinic.data.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }

    @GetMapping("/find")
    public ModelAndView findOwners() {
        return new ModelAndView("/owners/findOwners");
    }

    @GetMapping("/{ownerId}")
    public ModelAndView findOwner(@PathVariable Long ownerId) {
        ModelAndView modelAndView = new ModelAndView("/owners/ownerDetails");
        modelAndView.addObject(ownerService.findById(ownerId));
        return modelAndView;
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model) {
        if (owner.getLastName() == null) {
            owner.setLastName("");
        }

        List<Owner> results = this.ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");
        if (results.isEmpty()) {
            result.rejectValue("lastName", "notFound", "not found");
            return "/owners/findOwners";
        } else if (results.size() == 1) {
            owner = (Owner)results.get(0);
            return "redirect:/owners/" + owner.getId();
        } else {
            model.addAttribute("selections", results);
            return "/owners/ownersList";
        }
    }

    @GetMapping({"/new"})
    public String initCreationForm(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return "/owners/saveOwnerForm";
    }

    @PostMapping({"/new"})
    public String processCreationForm(@Valid Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return "/owners/saveOwnerForm";
        } else {
            Owner savedOwner = (Owner)this.ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }

    @GetMapping({"/{ownerId}/edit"})
    public String initUpdateOwnerForm(@PathVariable Long ownerId, Model model) {
        model.addAttribute(this.ownerService.findById(ownerId));
        return "/owners/saveOwnerForm";
    }

    @PostMapping({"/{ownerId}/edit"})
    public String processUpdateOwnerForm(@Valid Owner owner, @PathVariable Long ownerId, BindingResult result) {
        if (result.hasErrors()) {
            return "/owners/saveOwnerForm";
        } else {
            owner.setId(ownerId);
            Owner savedOwner = (Owner)this.ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }

}
