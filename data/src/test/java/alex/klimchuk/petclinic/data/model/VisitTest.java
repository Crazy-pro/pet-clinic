package alex.klimchuk.petclinic.data.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
public class VisitTest {

    @Test
    public void testConstructor() {
        LocalDate date = LocalDate.ofEpochDay(1L);

        Owner owner = new Owner();
        owner.setAddress("42 Main St");
        owner.setCity("Oxford");
        owner.setFirstName("Jane");
        owner.setId(123L);
        owner.setLastName("Doe");
        owner.setPets(new HashSet<>());
        owner.setTelephone("4105551212");

        PetType petType = new PetType();
        petType.setId(123L);
        petType.setName("Dog");

        Pet pet = new Pet();
        pet.setBirthDate(LocalDate.ofEpochDay(1L));
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(owner);
        pet.setPetType(petType);
        pet.setVisits(new HashSet<>());

        assertSame(date, (new Visit(123L, date, "Characteristics", pet)).getDate());
    }

}
