package alex.klimchuk.petclinic.data.services.impl;

import alex.klimchuk.petclinic.data.model.Speciality;
import alex.klimchuk.petclinic.data.repositories.SpecialityRepository;
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
public class SpecialityServiceImplTest {
    public static final Long SPECIALITY_ID = 1L;

    @Mock
    private SpecialityRepository specialityRepository;

    @InjectMocks
    private SpecialityServiceImpl specialityService;

    private Speciality specialityMock;

    @BeforeEach
    public void setUp() {
        specialityMock = Speciality.builder()
                .id(SPECIALITY_ID)
                .build();
    }

    @Test
    public void testFindAll() {
        Set<Speciality> specialitiesMock = new HashSet<>();
        specialitiesMock.add(Speciality.builder().id(1L).build());
        specialitiesMock.add(Speciality.builder().id(2L).build());
        specialitiesMock.add(Speciality.builder().id(3L).build());

        when(specialityService.findAll()).thenReturn(specialitiesMock);

        Set<Speciality> specialities = specialityService.findAll();

        assertNotNull(specialities);
        assertEquals(3, specialities.size());
    }

    @Test
    public void testFindById() {
        when(specialityRepository.findById(anyLong())).thenReturn(Optional.of(specialityMock));

        Speciality speciality = specialityService.findById(SPECIALITY_ID);

        assertNotNull(speciality);
        assertEquals(SPECIALITY_ID, speciality.getId());
    }

    @Test
    public void testFindByIdNotFound() {
        when(specialityRepository.findById(anyLong())).thenReturn(Optional.empty());

        Speciality speciality = specialityService.findById(SPECIALITY_ID);

        assertNull(speciality);
    }

    @Test
    public void testSave() {
        when(specialityRepository.save(any())).thenReturn(specialityMock);

        Speciality speciality = specialityService.save(specialityMock);

        assertNotNull(speciality);
        verify(specialityRepository).save(any());
    }

    @Test
    public void testDelete() {
        specialityService.delete(specialityMock);

        verify(specialityRepository).delete(any());
    }

    @Test
    public void testDeleteById() {
        specialityService.deleteById(SPECIALITY_ID);

        verify(specialityRepository, times(1)).deleteById(anyLong());
    }

}
