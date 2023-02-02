package alex.klimchuk.petclinic.data.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
public class VetTest {

    @Test
    public void testConstructor() {
        HashSet<Speciality> specialitySet = new HashSet<>();
        Vet actualVet = new Vet(123L, "Jane", "Doe", specialitySet);
        Set<Speciality> specialities = actualVet.getSpecialities();

        assertEquals("Jane", actualVet.getFirstName());
        assertFalse(actualVet.isNew());
        assertSame(specialitySet, specialities);
        assertTrue(specialities.isEmpty());
        assertEquals("Doe", actualVet.getLastName());
        assertEquals(123L, actualVet.getId().longValue());
    }

}
