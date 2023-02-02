package alex.klimchuk.petclinic.data.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
public class PetTypeTest {

    @Test
    public void testConstructor() {
        assertEquals("Dog", (new PetType(123L, "Dog")).toString());
    }

}
