package alex.klimchuk.petclinic.web.bootsrap;

import alex.klimchuk.petclinic.data.model.Owner;
import alex.klimchuk.petclinic.data.model.PetType;
import alex.klimchuk.petclinic.data.model.Vet;
import alex.klimchuk.petclinic.data.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("PetTypes loaded!");

        Owner owner1 = new Owner();
        owner1.setFirstName("Alex");
        owner1.setLastName("Born");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Bjorn");
        owner2.setLastName("Lodbrok");

        ownerService.save(owner2);

        System.out.println("Owners loaded!");

        Vet vet1 = new Vet();
        vet1.setFirstName("Mike");
        vet1.setLastName("Yalovoy");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Stas");
        vet2.setLastName("Commit");

        vetService.save(vet2);

        System.out.println("Vets loaded!");
    }

}
