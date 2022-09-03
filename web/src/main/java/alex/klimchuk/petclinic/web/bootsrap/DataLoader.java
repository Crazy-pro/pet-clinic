package main.java.alex.klimchuk.petclinic.web.bootsrap;

import main.java.alex.klimchuk.petclinic.data.model.Owner;
import main.java.alex.klimchuk.petclinic.data.model.Vet;
import main.java.alex.klimchuk.petclinic.data.services.*;
import main.java.alex.klimchuk.petclinic.data.services.map.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Alex");
        owner1.setLastName("Born");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Bjorn");
        owner2.setLastName("Lodbrok");

        ownerService.save(owner2);

        System.out.println("Owners loaded!");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Mike");
        vet1.setLastName("Yalovoy");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Stas");
        vet2.setLastName("Commit");

        vetService.save(vet2);

        System.out.println("Vets loaded!");

    }

}
