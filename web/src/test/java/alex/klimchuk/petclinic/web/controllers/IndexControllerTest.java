package alex.klimchuk.petclinic.web.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@ExtendWith(MockitoExtension.class)
public class IndexControllerTest {

    @InjectMocks
    IndexController indexController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
    }

    @Test
    public void testMainPageHandler() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("/homePage"));
    }

    @Test
    public void testErrorPageHandler() throws Exception {
        mockMvc.perform(get("/error-page"))
                .andExpect(status().isOk())
                .andExpect(view().name("/errorPage"));
    }

}
