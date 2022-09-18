package alex.klimchuk.petclinic.web.controllers;

import alex.klimchuk.petclinic.data.model.Owner;
import alex.klimchuk.petclinic.data.model.Pet;
import alex.klimchuk.petclinic.data.model.PetType;
import alex.klimchuk.petclinic.data.services.PetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@ExtendWith(MockitoExtension.class)
public class VisitControllerTest {

    @Mock
    private PetService petService;

    @InjectMocks
    private VisitController visitController;

    private MockMvc mockMvc;

    private final UriTemplate visitsUriTemplate = new UriTemplate("/owners/{ownerId}/pets/{petId}/visits/new");
    private final Map<String, String> uriVariables = new HashMap<>();
    private URI visitsUri;

    @BeforeEach
    public void setUp() {
        Long petId = 1L;
        Long ownerId = 1L;
        when(petService.findById(anyLong()))
                .thenReturn(Pet.builder()
                        .id(petId)
                        .birthDate(LocalDate.of(2018, 11, 13))
                        .name("Cutie")
                        .visits(new HashSet<>())
                        .owner(Owner.builder()
                                .id(ownerId)
                                .lastName("Doe")
                                .firstName("Joe")
                                .build())
                        .petType(PetType.builder()
                                .name("Dog")
                                .build())
                        .build());

        uriVariables.clear();
        uriVariables.put("ownerId", ownerId.toString());
        uriVariables.put("petId", petId.toString());
        visitsUri = visitsUriTemplate.expand(uriVariables);

        mockMvc = MockMvcBuilders.standaloneSetup(visitController).build();
    }

    @Test
    public void testInitNewVisitForm() throws Exception {
        mockMvc.perform(get(visitsUri))
                .andExpect(status().isOk())
                .andExpect(view().name("/pets/saveVisitForm"));
    }

    @Test
    public void testProcessNewVisitForm() throws Exception {
        mockMvc.perform(post(visitsUri)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("date", "11-11-2018")
                        .param("description", "yet another visit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/{ownerId}"))
                .andExpect(model().attributeExists("visit"));
    }

}
