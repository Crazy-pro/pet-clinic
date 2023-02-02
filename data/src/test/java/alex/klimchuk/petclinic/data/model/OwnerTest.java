package alex.klimchuk.petclinic.data.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
public class OwnerTest {

    @Test
    public void testConstructor() {
        Owner actualOwner = new Owner(123L, "Jane", "Doe", "42 Main St", "Oxford", "4105551212", new HashSet<>());

        assertEquals("42 Main St", actualOwner.getAddress());
        assertFalse(actualOwner.isNew());
        assertEquals("4105551212", actualOwner.getTelephone());
        assertTrue(actualOwner.getPets().isEmpty());
        assertEquals("Doe", actualOwner.getLastName());
        assertEquals("Jane", actualOwner.getFirstName());
        assertEquals("Oxford", actualOwner.getCity());
    }

    @Test
    public void testGetPet() {
        assertNull((new Owner()).getPet("Bella"));
        assertNull((new Owner()).getPet("Bella", true));
    }

    @Test
    public void testGetPet2() {
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

        LinkedHashSet<Pet> petSet = new LinkedHashSet<>();
        petSet.add(pet);

        Owner owner1 = new Owner();
        owner1.setAddress("42 Main St");
        owner1.setCity("Oxford");
        owner1.setFirstName("Jane");
        owner1.setId(123L);
        owner1.setLastName("Doe");
        owner1.setTelephone("4105551212");
        owner1.setPets(petSet);

        assertNull(owner1.getPet("foo"));
    }

    @Test
    public void testGetPet3() {
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
        pet.setName("foo");
        pet.setOwner(owner);
        pet.setPetType(petType);
        pet.setVisits(new HashSet<>());

        LinkedHashSet<Pet> petSet = new LinkedHashSet<>();
        petSet.add(pet);

        Owner owner1 = new Owner();
        owner1.setAddress("42 Main St");
        owner1.setCity("Oxford");
        owner1.setFirstName("Jane");
        owner1.setId(123L);
        owner1.setLastName("Doe");
        owner1.setTelephone("4105551212");
        owner1.setPets(petSet);

        assertSame(pet, owner1.getPet("foo"));
    }

    @Test
    public void testGetPet4() {
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

        LinkedHashSet<Pet> petSet = new LinkedHashSet<>();
        petSet.add(pet);

        Owner owner1 = new Owner();
        owner1.setAddress("42 Main St");
        owner1.setCity("Oxford");
        owner1.setFirstName("Jane");
        owner1.setId(123L);
        owner1.setLastName("Doe");
        owner1.setTelephone("4105551212");
        owner1.setPets(petSet);

        assertNull(owner1.getPet("foo", false));
    }

    @Test
    public void testGetPet5() {
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
        pet.setName("foo");
        pet.setOwner(owner);
        pet.setPetType(petType);
        pet.setVisits(new HashSet<>());

        LinkedHashSet<Pet> petSet = new LinkedHashSet<>();
        petSet.add(pet);

        Owner owner1 = new Owner();
        owner1.setAddress("42 Main St");
        owner1.setCity("Oxford");
        owner1.setFirstName("Jane");
        owner1.setId(123L);
        owner1.setLastName("Doe");
        owner1.setTelephone("4105551212");
        owner1.setPets(petSet);

        assertSame(pet, owner1.getPet("foo", false));
    }

    @Test
    public void testGetPet6() {
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

        LinkedHashSet<Pet> petSet = new LinkedHashSet<>();
        petSet.add(pet);

        Owner owner1 = new Owner();
        owner1.setAddress("42 Main St");
        owner1.setCity("Oxford");
        owner1.setFirstName("Jane");
        owner1.setId(123L);
        owner1.setLastName("Doe");
        owner1.setTelephone("4105551212");
        owner1.setPets(petSet);

        assertNull(owner1.getPet("foo", true));
    }

}
