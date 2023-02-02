package alex.klimchuk.petclinic.data.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
public class PersonTest {

    @Test
    public void testConstructor() {
        Person actualPerson = new Person(123L, "Jane", "Doe");

        assertEquals("Jane", actualPerson.getFirstName());
        assertFalse(actualPerson.isNew());
        assertEquals("Doe", actualPerson.getLastName());
        assertEquals(123L, actualPerson.getId().longValue());
    }

}
