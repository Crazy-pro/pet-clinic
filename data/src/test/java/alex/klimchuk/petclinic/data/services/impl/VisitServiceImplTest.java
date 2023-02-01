package alex.klimchuk.petclinic.data.services.impl;

import alex.klimchuk.petclinic.data.model.Visit;
import alex.klimchuk.petclinic.data.repositories.VisitRepository;
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
public class VisitServiceImplTest {
    public static final Long VISIT_ID = 1L;

    @Mock
    private VisitRepository visitRepository;

    @InjectMocks
    private VisitServiceImpl visitService;

    private Visit visitMock;

    @BeforeEach
    public void setUp() {
        visitMock = Visit.builder()
                .id(VISIT_ID)
                .build();
    }

    @Test
    public void testFindAll() {
        Set<Visit> visitsMock = new HashSet<>();
        visitsMock.add(Visit.builder().id(1L).build());
        visitsMock.add(Visit.builder().id(2L).build());
        visitsMock.add(Visit.builder().id(3L).build());

        when(visitService.findAll()).thenReturn(visitsMock);

        Set<Visit> visits = visitService.findAll();

        assertNotNull(visits);
        assertEquals(3, visits.size());
    }

    @Test
    public void testFindById() {
        when(visitRepository.findById(anyLong())).thenReturn(Optional.of(visitMock));

        Visit visit = visitService.findById(VISIT_ID);

        assertNotNull(visit);
        assertEquals(VISIT_ID, visit.getId());
    }

    @Test
    public void testFindByIdNotFound() {
        when(visitRepository.findById(anyLong())).thenReturn(Optional.empty());

        Visit visit = visitService.findById(VISIT_ID);

        assertNull(visit);
    }

    @Test
    public void testSave() {
        when(visitRepository.save(any())).thenReturn(visitMock);

        Visit visit = visitService.save(visitMock);

        assertNotNull(visit);
        verify(visitRepository).save(any());
    }

    @Test
    public void testDelete() {
        visitService.delete(visitMock);

        verify(visitRepository).delete(any());
    }

    @Test
    public void testDeleteById() {
        visitService.deleteById(VISIT_ID);

        verify(visitRepository, times(1)).deleteById(anyLong());
    }

}
