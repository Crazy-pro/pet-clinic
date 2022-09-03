package main.java.alex.klimchuk.petclinic.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */

@Controller
@RequestMapping("/vets/")
public class VetController {

    @RequestMapping({"index", "index.html"})
    public String listVets() {
        return "vets/index.html";
    }

}
