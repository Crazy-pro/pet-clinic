package alex.klimchuk.petclinic.data.services.map;

import alex.klimchuk.petclinic.data.model.Speciality;
import alex.klimchuk.petclinic.data.model.Vet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
public class VetMapServiceTest {
    public static final Long VET_ID = 1L;

    private VetMapService vetMapService;

    @BeforeEach
    public void setUp() {
        vetMapService = new VetMapService(new SpecialityMapService());
        vetMapService.save(Vet.builder().id(VET_ID).specialities(Set.of(new Speciality(1L, "Test Speciality"))).build());
    }

    @Test
    public void testFindAll() {
        Set<Vet> vets = vetMapService.findAll();

        assertEquals(1, vets.size());
    }

    @Test
    public void testFindById() {
        Vet vet = vetMapService.findById(VET_ID);

        assertEquals(VET_ID, vet.getId());
    }

    @Test
    public void testSaveVet() {
        Vet vet = vetMapService.save(Vet.builder().id(VET_ID).specialities(Set.of(new Speciality(1L, ""))).build());
        Vet savedVet = vetMapService.save(vet);

        assertNotNull(savedVet);
        assertNotNull(savedVet.getId());
    }

    @Test
    public void testSaveVetWithoutId() {
        Vet vet = vetMapService.save(new Vet());
        Vet savedVet = vetMapService.save(vet);

        assertNotNull(savedVet);
        assertNotNull(savedVet.getId());
    }

    @Test
    public void testSaveVetWithExistingId() {
        Vet vet = vetMapService.save(Vet.builder().id(VET_ID).specialities(Set.of(new Speciality(1L, ""))).build());
        Vet savedVet = vetMapService.save(vet);

        assertEquals(vet.getId(), savedVet.getId());
    }

    @Test
    public void testDelete() {
        vetMapService.delete(vetMapService.findById(VET_ID));

        assertEquals(0, vetMapService.findAll().size());
    }

    @Test
    public void testDeleteById() {
        vetMapService.deleteById(VET_ID);

        assertEquals(0, vetMapService.findAll().size());
    }

}
