package alex.klimchuk.petclinic.data.services.map;

import alex.klimchuk.petclinic.data.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
public class OwnerMapServiceTest {

    public static final String LAST_NAME = "Alex";
    public static final Long OWNER_ID = 1L;

    private OwnerMapService ownerMapService;

    @BeforeEach
    public void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(OWNER_ID).lastName(LAST_NAME).build());
    }

    @Test
    public void testFindAll() {
        Set<Owner> owners = ownerMapService.findAll();

        assertEquals(1, owners.size());
    }

    @Test
    public void testFindById() {
        Owner owner = ownerMapService.findById(OWNER_ID);

        assertEquals(OWNER_ID, owner.getId());
    }

    @Test
    public void testFindByLastName() {
        Owner owner = ownerMapService.findByLastName(LAST_NAME);

        assertNotNull(owner);
        assertEquals(OWNER_ID, owner.getId());
    }

    @Test
    public void testFindByLastNameNotFound() {
        Owner owner = ownerMapService.findByLastName("Max");

        assertNull(owner);
    }

    @Test
    public void testFindAllByLastNameLike() {
        List<Owner> owners = ownerMapService.findAllByLastNameLike(LAST_NAME);

        assertNotNull(owners);
        assertEquals(1, owners.size());
    }

    @Test
    public void testSaveOwner() {
        Owner owner = ownerMapService.save(Owner.builder().id(2L).build());
        Owner savedOwner = ownerMapService.save(owner);

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    public void testSaveOwnerWithoutId() {
        Owner owner = ownerMapService.save(new Owner());
        Owner savedOwner = ownerMapService.save(owner);

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    public void testSaveOwnerWithExistingId() {
        Owner owner = ownerMapService.save(Owner.builder().id(2L).build());
        Owner savedOwner = ownerMapService.save(owner);

        assertEquals(owner.getId(), savedOwner.getId());
    }

    @Test
    public void testDelete() {
        ownerMapService.delete(ownerMapService.findById(OWNER_ID));

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    public void testDeleteById() {
        ownerMapService.deleteById(OWNER_ID);

        assertEquals(0, ownerMapService.findAll().size());
    }

}
