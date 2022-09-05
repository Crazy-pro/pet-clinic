package alex.klimchuk.petclinic.web.controllers;

import alex.klimchuk.petclinic.data.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright Alex Klimchuk (c) 2022.
*/
@Controller
@RequestMapping("/vets")
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping
    public String listVets(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/vetsList";
    }

}
