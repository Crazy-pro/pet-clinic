package alex.klimchuk.petclinic.web.controllers;

import alex.klimchuk.petclinic.data.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public String listOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/ownersList";
    }

    @GetMapping("/find")
    public String findOwners() {
        return "notImplementedPage";
    }

}
