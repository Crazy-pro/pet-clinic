package alex.klimchuk.petclinic.data.services.map;

import alex.klimchuk.petclinic.data.model.Speciality;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
public class SpecialityMapServiceTest {
    public static final Long SPECIALITY_ID = 1L;

    private SpecialityMapService specialityMapService;

    @BeforeEach
    public void setUp() {
        specialityMapService = new SpecialityMapService();
        specialityMapService.save(Speciality.builder().id(SPECIALITY_ID).build());
    }

    @Test
    public void testFindAll() {
        Set<Speciality> specialities = specialityMapService.findAll();

        assertEquals(1, specialities.size());
    }

    @Test
    public void testFindById() {
        Speciality speciality = specialityMapService.findById(SPECIALITY_ID);

        assertEquals(SPECIALITY_ID, speciality.getId());
    }

    @Test
    public void testSaveSpeciality() {
        Speciality speciality = specialityMapService.save(Speciality.builder().id(2L).build());
        Speciality savedSpeciality = specialityMapService.save(speciality);

        assertNotNull(savedSpeciality);
        assertNotNull(savedSpeciality.getId());
    }

    @Test
    public void testSaveSpecialityWithoutId() {
        Speciality speciality = specialityMapService.save(new Speciality());
        Speciality savedSpeciality = specialityMapService.save(speciality);

        assertNotNull(savedSpeciality);
        assertNotNull(savedSpeciality.getId());
    }

    @Test
    public void testSaveSpecialityWithExistingId() {
        Speciality speciality = specialityMapService.save(Speciality.builder().id(SPECIALITY_ID).build());
        Speciality savedSpeciality = specialityMapService.save(speciality);

        assertEquals(speciality.getId(), savedSpeciality.getId());
    }

    @Test
    public void testDelete() {
        specialityMapService.delete(specialityMapService.findById(SPECIALITY_ID));

        assertEquals(0, specialityMapService.findAll().size());
    }

    @Test
    public void testDeleteById() {
        specialityMapService.deleteById(SPECIALITY_ID);

        assertEquals(0, specialityMapService.findAll().size());
    }

}
