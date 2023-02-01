package alex.klimchuk.petclinic.data.services.impl;

import alex.klimchuk.petclinic.data.model.Pet;
import alex.klimchuk.petclinic.data.repositories.PetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@ExtendWith(MockitoExtension.class)
public class PetServiceImplTest {
    public static final Long PET_ID = 1L;

    @Mock
    private PetRepository petRepository;

    @InjectMocks
    private PetServiceImpl petService;

    private Pet petMock;

    @BeforeEach
    public void setUp() {
        petMock = Pet.builder()
                .id(PET_ID)
                .build();
    }

    @Test
    public void testFindAll() {
        Set<Pet> petsMock = new HashSet<>();
        petsMock.add(Pet.builder().id(1L).build());
        petsMock.add(Pet.builder().id(2L).build());
        petsMock.add(Pet.builder().id(3L).build());

        when(petService.findAll()).thenReturn(petsMock);

        Set<Pet> pets = petService.findAll();

        assertNotNull(pets);
        assertEquals(3, pets.size());
    }

    @Test
    public void testFindById() {
        when(petRepository.findById(anyLong())).thenReturn(Optional.of(petMock));

        Pet pet = petService.findById(PET_ID);

        assertNotNull(pet);
        assertEquals(PET_ID, pet.getId());
    }

    @Test
    public void testFindByIdNotFound() {
        when(petRepository.findById(anyLong())).thenReturn(Optional.empty());

        Pet pet = petService.findById(PET_ID);

        assertNull(pet);
    }

    @Test
    public void testSave() {
        when(petRepository.save(any())).thenReturn(petMock);

        Pet pet = petService.save(petMock);

        assertNotNull(pet);
        verify(petRepository).save(any());
    }

    @Test
    public void testDelete() {
        petService.delete(petMock);

        verify(petRepository).delete(any());
    }

    @Test
    public void testDeleteById() {
        petService.deleteById(PET_ID);

        verify(petRepository, times(1)).deleteById(anyLong());
    }

}
