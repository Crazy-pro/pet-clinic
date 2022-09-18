package alex.klimchuk.petclinic.web.controllers;

import alex.klimchuk.petclinic.data.model.Owner;
import alex.klimchuk.petclinic.data.model.Pet;
import alex.klimchuk.petclinic.data.model.PetType;
import alex.klimchuk.petclinic.data.services.OwnerService;
import alex.klimchuk.petclinic.data.services.PetService;
import alex.klimchuk.petclinic.data.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@ExtendWith(MockitoExtension.class)
public class PetControllerTest {

    @Mock
    private PetService petService;

    @Mock
    private OwnerService ownerService;

    @Mock
    private PetTypeService petTypeService;

    @InjectMocks
    private PetController petController;

    private MockMvc mockMvc;

    private Owner ownerMock;

    private Set<PetType> petTypesMock;

    @BeforeEach
    public void setUp() {
        ownerMock = Owner.builder().id(1L).build();

        petTypesMock = new HashSet<>();
        petTypesMock.add(PetType.builder().id(1L).name("Dog").build());
        petTypesMock.add(PetType.builder().id(2L).name("Cat").build());

        mockMvc = MockMvcBuilders.standaloneSetup(petController).build();
    }

    @Test
    public void testInitCreationForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(ownerMock);
        when(petTypeService.findAll()).thenReturn(petTypesMock);

        mockMvc.perform(get("/owners/1/pets/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(view().name("/pets/savePetForm"));
    }

    @Test
    public void testProcessCreationForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(ownerMock);
        when(petTypeService.findAll()).thenReturn(petTypesMock);

        mockMvc.perform(post("/owners/1/pets/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));

        verify(petService).save(any());
    }

    @Test
    public void testInitUpdateForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(ownerMock);
        when(petTypeService.findAll()).thenReturn(petTypesMock);
        when(petService.findById(anyLong())).thenReturn(Pet.builder().id(2L).build());

        mockMvc.perform(get("/owners/1/pets/2/edit"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(view().name("/pets/savePetForm"));
    }

    @Test
    public void testProcessUpdateForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(ownerMock);
        when(petTypeService.findAll()).thenReturn(petTypesMock);

        mockMvc.perform(post("/owners/1/pets/2/edit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));

        verify(petService).save(any());
    }

}
