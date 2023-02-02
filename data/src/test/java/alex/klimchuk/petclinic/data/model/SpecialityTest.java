package alex.klimchuk.petclinic.data.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
public class SpecialityTest {

    @Test
    public void testConstructor() {
        Speciality actualSpeciality = new Speciality(123L, "Characteristics");

        assertEquals("Characteristics", actualSpeciality.getDescription());
        assertFalse(actualSpeciality.isNew());
        assertEquals(123L, actualSpeciality.getId().longValue());
    }
    
}
