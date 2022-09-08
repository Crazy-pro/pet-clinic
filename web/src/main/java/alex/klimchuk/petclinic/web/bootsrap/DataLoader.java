package alex.klimchuk.petclinic.web.bootsrap;

import alex.klimchuk.petclinic.data.model.*;
import alex.klimchuk.petclinic.data.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("PetTypes loaded!");

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Alex");
        owner1.setLastName("Born");
        owner1.setAddress("21 Jump Street");
        owner1.setCity("San Francisko");
        owner1.setTelephone("+42222222997845");

        Pet annsCat = new Pet();
        annsCat.setName("Rock");
        annsCat.setOwner(owner1);
        annsCat.setPetType(savedCatPetType);
        annsCat.setBirthDate(LocalDate.now());
        owner1.getPets().add(annsCat);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Bjorn");
        owner2.setLastName("Lodbrok");
        owner2.setAddress("22 Jump Street");
        owner2.setCity("Boston");
        owner2.setTelephone("+42375246541245");

        Pet alexsDog = new Pet();
        alexsDog.setName("Rock");
        alexsDog.setOwner(owner2);
        alexsDog.setPetType(savedDogPetType);
        alexsDog.setBirthDate(LocalDate.now());
        owner2.getPets().add(alexsDog);

        ownerService.save(owner2);

        System.out.println("Owners loaded!");

        Visit catVisit = new Visit();
        catVisit.setPet(annsCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Funny Kitty");

        visitService.save(catVisit);

        System.out.println("Visits loaded!");

        Vet vet1 = new Vet();
        vet1.setFirstName("Mike");
        vet1.setLastName("Yalovoy");
        vet1.getSpecialities().add(savedDentistry);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Stas");
        vet2.setLastName("Commit");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Vets loaded!");

        System.out.println("Pets loaded!");
    }

}
