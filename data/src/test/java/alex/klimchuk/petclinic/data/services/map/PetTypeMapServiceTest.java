package alex.klimchuk.petclinic.data.services.map;

import alex.klimchuk.petclinic.data.model.PetType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
public class PetTypeMapServiceTest {
    public static final Long PET_TYPE_ID = 1L;

    private PetTypeMapService petTypeMapService;

    @BeforeEach
    public void setUp() {
        petTypeMapService = new PetTypeMapService();
        petTypeMapService.save(PetType.builder().id(PET_TYPE_ID).build());
    }

    @Test
    public void testFindAll() {
        Set<PetType> petTypes = petTypeMapService.findAll();

        assertEquals(1, petTypes.size());
    }

    @Test
    public void testFindById() {
        PetType petType = petTypeMapService.findById(PET_TYPE_ID);

        assertEquals(PET_TYPE_ID, petType.getId());
    }

    @Test
    public void testSavePetType() {
        PetType petType = petTypeMapService.save(PetType.builder().id(2L).build());
        PetType savedPetType = petTypeMapService.save(petType);

        assertNotNull(savedPetType);
        assertNotNull(savedPetType.getId());
    }

    @Test
    public void testSavePetTypeWithoutId() {
        PetType petType = petTypeMapService.save(new PetType());
        PetType savedPetType = petTypeMapService.save(petType);

        assertNotNull(savedPetType);
        assertNotNull(savedPetType.getId());
    }

    @Test
    public void testSavePetTypeWithExistingId() {
        PetType petType = petTypeMapService.save(PetType.builder().id(PET_TYPE_ID).build());
        PetType savedPetType = petTypeMapService.save(petType);

        assertEquals(petType.getId(), savedPetType.getId());
    }

    @Test
    public void testDelete() {
        petTypeMapService.delete(petTypeMapService.findById(PET_TYPE_ID));

        assertEquals(0, petTypeMapService.findAll().size());
    }

    @Test
    public void testDeleteById() {
        petTypeMapService.deleteById(PET_TYPE_ID);

        assertEquals(0, petTypeMapService.findAll().size());
    }

}
