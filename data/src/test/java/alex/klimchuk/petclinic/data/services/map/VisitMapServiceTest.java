package alex.klimchuk.petclinic.data.services.map;

import alex.klimchuk.petclinic.data.model.Pet;
import alex.klimchuk.petclinic.data.model.Visit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
public class VisitMapServiceTest {
    public static final Long VISIT_ID = 1L;

    private final Long PET_ID = 1L;

    private Pet testPet;

    private PetMapService petMapService;

    private VisitMapService visitMapService;

    @BeforeEach
    public void setUp() {
        visitMapService = new VisitMapService();
        petMapService = new PetMapService();
        testPet = petMapService.save(Pet.builder().id(PET_ID).build());
        visitMapService.save(Visit.builder().id(VISIT_ID).pet(testPet).build());
    }

    @Test
    public void testFindAll() {
        Set<Visit> visits = visitMapService.findAll();

        assertEquals(1, visits.size());
    }

    @Test
    public void testFindById() {
        Visit visit = visitMapService.findById(VISIT_ID);

        assertEquals(VISIT_ID, visit.getId());
    }

    @Test
    public void testSaveVisit() {
        Visit visit = visitMapService.save(Visit.builder().id(3L).pet(testPet).build());
        Visit savedVisit = visitMapService.save(visit);

        assertNotNull(savedVisit);
        assertNotNull(savedVisit.getId());
    }

    @Test
    public void testSaveVisitWithoutId() {
        Visit visit = visitMapService.save(Visit.builder().pet(testPet).build());
        Visit savedVisit = visitMapService.save(visit);

        assertNotNull(savedVisit);
        assertNotNull(savedVisit.getId());
    }

    @Test
    public void testSaveVisitWithExistingId() {
        Visit visit = visitMapService.save(Visit.builder().id(VISIT_ID).pet(testPet).build());
        Visit savedVisit = visitMapService.save(visit);

        assertEquals(visit.getId(), savedVisit.getId());
    }

    @Test
    public void testDelete() {
        visitMapService.delete(visitMapService.findById(VISIT_ID));

        assertEquals(0, visitMapService.findAll().size());
    }

    @Test
    public void testDeleteById() {
        visitMapService.deleteById(VISIT_ID);

        assertEquals(0, visitMapService.findAll().size());
    }

}
