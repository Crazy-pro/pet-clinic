package alex.klimchuk.petclinic.web.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@ExtendWith(MockitoExtension.class)
public class IndexControllerTest {

    @InjectMocks
    IndexController indexController;

    @Mock
    ModelAndView modelAndView;

    @Test
    public void testMainPageHandler() {
        when(modelAndView.getViewName()).thenReturn("/homePage");

        ModelAndView result = indexController.mainPageHandler();

        assertThat(result.getViewName()).isEqualTo("/homePage");
    }

    @Test
    public void testErrorPageHandler() {
        when(modelAndView.getViewName()).thenReturn("/errorPage");

        ModelAndView result = indexController.errorPageHandler();

        assertThat(result.getViewName()).isEqualTo("/errorPage");
    }

}
