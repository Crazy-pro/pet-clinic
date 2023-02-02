package alex.klimchuk.petclinic.data.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
public class PetTest {

    @Test
    public void testConstructor() {
        PetType petType = new PetType();
        petType.setId(123L);
        petType.setName("Dog");

        Owner owner = new Owner();
        owner.setAddress("42 Main St");
        owner.setCity("Oxford");
        owner.setFirstName("Jane");
        owner.setId(123L);
        owner.setLastName("Doe");
        owner.setPets(new HashSet<>());
        owner.setTelephone("4105551212");
        
        LocalDate birthDate = LocalDate.ofEpochDay(1L);
        Pet actualPet = new Pet(123L, "Bella", petType, owner, birthDate, new HashSet<>());

        assertEquals("1970-01-02", actualPet.getBirthDate().toString());
        assertFalse(actualPet.isNew());
        assertTrue(actualPet.getVisits().isEmpty());
        assertSame(petType, actualPet.getPetType());
        assertSame(owner, actualPet.getOwner());
        assertEquals("Bella", actualPet.getName());
    }

    @Test
    public void testConstructor2() {
        PetType petType = new PetType();
        petType.setId(123L);
        petType.setName("Dog");

        Owner owner = new Owner();
        owner.setAddress("42 Main St");
        owner.setCity("Oxford");
        owner.setFirstName("Jane");
        owner.setId(123L);
        owner.setLastName("Doe");
        owner.setPets(new HashSet<>());
        owner.setTelephone("4105551212");
        
        LocalDate birthDate = LocalDate.ofEpochDay(1L);

        Owner owner1 = new Owner();
        owner1.setAddress("42 Main St");
        owner1.setCity("Oxford");
        owner1.setFirstName("Jane");
        owner1.setId(123L);
        owner1.setLastName("Doe");
        owner1.setPets(new HashSet<>());
        owner1.setTelephone("4105551212");

        PetType petType1 = new PetType();
        petType1.setId(123L);
        petType1.setName("Dog");

        Pet pet = new Pet();
        pet.setBirthDate(LocalDate.ofEpochDay(1L));
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(owner1);
        pet.setPetType(petType1);
        pet.setVisits(new HashSet<>());

        Visit visit = new Visit();
        visit.setDate(LocalDate.ofEpochDay(1L));
        visit.setDescription("Characteristics");
        visit.setId(123L);
        visit.setPet(pet);

        HashSet<Visit> visitSet = new HashSet<>();
        visitSet.add(visit);
        Pet actualPet = new Pet(123L, "Bella", petType, owner, birthDate, visitSet);

        assertEquals("1970-01-02", actualPet.getBirthDate().toString());
        assertFalse(actualPet.isNew());
        assertEquals(1, actualPet.getVisits().size());
        assertSame(petType, actualPet.getPetType());
        assertSame(owner, actualPet.getOwner());
        assertEquals("Bella", actualPet.getName());
    }
    
}
