package alex.klimchuk.petclinic.data.services.map;

import alex.klimchuk.petclinic.data.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
public class PetMapServiceTest {

    private final Long PET_ID = 1L;

    private PetMapService petMapService;

    @BeforeEach
    public void setUp() {
        petMapService = new PetMapService();
        petMapService.save(Pet.builder().id(PET_ID).build());
    }

    @Test
    public void testFindAll() {
        Set<Pet> petSet = petMapService.findAll();

        assertEquals(1, petSet.size());
    }

    @Test
    public void testFindById() {
        Pet pet = petMapService.findById(PET_ID);

        assertEquals(PET_ID, pet.getId());
    }

    @Test
    public void testFindByNotExistingId() {
        Pet pet = petMapService.findById(5L);

        assertNull(pet);
    }

    @Test
    public void testFindByNullId() {
        Pet pet = petMapService.findById(null);

        assertNull(pet);
    }

    @Test
    public void testSave() {
        Long id = 2L;

        Pet pet = Pet.builder().id(id).build();

        Pet savedPet = petMapService.save(pet);

        assertEquals(id, savedPet.getId());
    }

    @Test
    public void testSavePetWithExistingId() {
        Pet pet = Pet.builder().id(PET_ID).build();

        Pet savedPet = petMapService.save(pet);

        assertEquals(PET_ID, savedPet.getId());
        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    public void testSavePetWithoutId() {
        Pet savedPet = petMapService.save(new Pet());

        assertNotNull(savedPet);
        assertNotNull(savedPet.getId());
        assertEquals(2, petMapService.findAll().size());
    }

    @Test
    public void testDelete() {
        petMapService.delete(petMapService.findById(PET_ID));

        assertEquals(0, petMapService.findAll().size());
    }

    @Test
    public void testDeleteNullPet() {
        petMapService.delete(null);

        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    public void testDeletePetWithNullId() {
        petMapService.delete(new Pet());

        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    public void testDeletePetWithWrongId() {
        Pet pet = new Pet();
        pet.setId(70L);

        petMapService.delete(pet);

        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    public void testDeleteById() {
        petMapService.deleteById(PET_ID);

        assertEquals(0, petMapService.findAll().size());
    }

    @Test
    public void testDeleteByWrongId() {
        petMapService.deleteById(5L);

        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    public void testDeleteByNullId() {
        petMapService.deleteById(null);

        assertEquals(1, petMapService.findAll().size());
    }

}
