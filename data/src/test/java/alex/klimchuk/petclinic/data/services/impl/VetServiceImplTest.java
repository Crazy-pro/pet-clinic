package alex.klimchuk.petclinic.data.services.impl;

import alex.klimchuk.petclinic.data.model.Vet;
import alex.klimchuk.petclinic.data.repositories.VetRepository;
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
public class VetServiceImplTest {
    public static final Long VET_ID = 1L;

    @Mock
    private VetRepository vetRepository;

    @InjectMocks
    private VetServiceImpl vetService;

    private Vet vetMock;

    @BeforeEach
    public void setUp() {
        vetMock = Vet.builder()
                .id(VET_ID)
                .build();
    }

    @Test
    public void testFindAll() {
        Set<Vet> vetsMock = new HashSet<>();
        vetsMock.add(Vet.builder().id(1L).build());
        vetsMock.add(Vet.builder().id(2L).build());
        vetsMock.add(Vet.builder().id(3L).build());

        when(vetService.findAll()).thenReturn(vetsMock);

        Set<Vet> vets = vetService.findAll();

        assertNotNull(vets);
        assertEquals(3, vets.size());
    }

    @Test
    public void testFindById() {
        when(vetRepository.findById(anyLong())).thenReturn(Optional.of(vetMock));

        Vet vet = vetService.findById(VET_ID);

        assertNotNull(vet);
        assertEquals(VET_ID, vet.getId());
    }

    @Test
    public void testFindByIdNotFound() {
        when(vetRepository.findById(anyLong())).thenReturn(Optional.empty());

        Vet vet = vetService.findById(VET_ID);

        assertNull(vet);
    }

    @Test
    public void testSave() {
        when(vetRepository.save(any())).thenReturn(vetMock);

        Vet vet = vetService.save(vetMock);

        assertNotNull(vet);
        verify(vetRepository).save(any());
    }

    @Test
    public void testDelete() {
        vetService.delete(vetMock);

        verify(vetRepository).delete(any());
    }

    @Test
    public void testDeleteById() {
        vetService.deleteById(VET_ID);

        verify(vetRepository, times(1)).deleteById(anyLong());
    }

}
