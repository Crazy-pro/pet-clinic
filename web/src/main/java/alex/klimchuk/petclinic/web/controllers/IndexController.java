package alex.klimchuk.petclinic.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@Controller
public class IndexController {

    @RequestMapping({"", "/", "index", "index.html"})
    public ModelAndView mainPageHandler() {
        return new ModelAndView("/homePage");
    }

    @RequestMapping({"/error-page"})
    public ModelAndView errorPageHandler() {
        return new ModelAndView("/errorPage");
    }

}
