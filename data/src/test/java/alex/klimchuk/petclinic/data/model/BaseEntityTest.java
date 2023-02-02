package alex.klimchuk.petclinic.data.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
public class BaseEntityTest {

    @Test
    public void testIsNew() {
        assertTrue((new BaseEntity()).isNew());
    }

    @Test
    public void testIsNew2() {
        Owner owner = new Owner();
        owner.setAddress("42 Main St");
        owner.setCity("Oxford");
        owner.setFirstName("Jane");
        owner.setId(123L);
        owner.setLastName("Doe");
        owner.setPets(new HashSet<>());
        owner.setTelephone("4105551212");

        assertFalse(owner.isNew());
    }

}
