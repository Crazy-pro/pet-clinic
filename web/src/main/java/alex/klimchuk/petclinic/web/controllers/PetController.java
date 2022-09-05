package alex.klimchuk.petclinic.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Copyright Alex Klimchuk (c) 2022.
*/
@Controller
@RequestMapping("/pets/")
public class PetController {

    @RequestMapping({"petsList", "petsList.html"})
    public String listPets() {
        return "pets/petsList";
    }

}
