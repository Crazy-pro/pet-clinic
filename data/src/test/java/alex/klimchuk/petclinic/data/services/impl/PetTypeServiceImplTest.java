package alex.klimchuk.petclinic.data.services.impl;

import alex.klimchuk.petclinic.data.model.PetType;
import alex.klimchuk.petclinic.data.repositories.PetTypeRepository;
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
public class PetTypeServiceImplTest {
    public static final Long PET_ID = 1L;

    @Mock
    private PetTypeRepository petTypeRepository;

    @InjectMocks
    private PetTypeServiceImpl petTypeService;

    private PetType petTypeMock;

    @BeforeEach
    public void setUp() {
        petTypeMock = PetType.builder()
                .id(PET_ID)
                .build();
    }

    @Test
    public void testFindAll() {
        Set<PetType> petTypesMock = new HashSet<>();
        petTypesMock.add(PetType.builder().id(1L).build());
        petTypesMock.add(PetType.builder().id(2L).build());
        petTypesMock.add(PetType.builder().id(3L).build());

        when(petTypeService.findAll()).thenReturn(petTypesMock);

        Set<PetType> petTypes = petTypeService.findAll();

        assertNotNull(petTypes);
        assertEquals(3, petTypes.size());
    }

    @Test
    public void testFindById() {
        when(petTypeRepository.findById(anyLong())).thenReturn(Optional.of(petTypeMock));

        PetType petType = petTypeService.findById(PET_ID);

        assertNotNull(petType);
        assertEquals(PET_ID, petType.getId());
    }

    @Test
    public void testFindByIdNotFound() {
        when(petTypeRepository.findById(anyLong())).thenReturn(Optional.empty());

        PetType petType = petTypeService.findById(PET_ID);

        assertNull(petType);
    }

    @Test
    public void testSave() {
        when(petTypeRepository.save(any())).thenReturn(petTypeMock);

        PetType petType = petTypeService.save(petTypeMock);

        assertNotNull(petType);
        verify(petTypeRepository).save(any());
    }

    @Test
    public void testDelete() {
        petTypeService.delete(petTypeMock);

        verify(petTypeRepository).delete(any());
    }

    @Test
    public void testDeleteById() {
        petTypeService.deleteById(PET_ID);

        verify(petTypeRepository, times(1)).deleteById(anyLong());
    }

}
