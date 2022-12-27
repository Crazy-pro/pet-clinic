package alex.klimchuk.petclinic.web.bootsrap;

import alex.klimchuk.petclinic.data.model.*;
import alex.klimchuk.petclinic.data.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@Slf4j
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
    public void run(String... args) {
        boolean isEmpty = petTypeService.findAll().isEmpty();

        if (isEmpty) {
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

        log.info("PetTypes loaded!");

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = Owner.builder()
                .firstName("Alex")
                .lastName("Born")
                .address("21 Jump Street")
                .city("San Francisco")
                .telephone("+42222222997845")
                .build();

        Pet annsCat = Pet.builder()
                .name("Rock")
                .owner(owner1)
                .petType(savedCatPetType)
                .birthDate(LocalDate.now())
                .build();

        owner1.getPets().add(annsCat);

        ownerService.save(owner1);

        Owner owner2 = Owner.builder()
                .firstName("Bjorn")
                .lastName("Lodbrok")
                .address("22 Jump Street")
                .city("Boston")
                .telephone("+42375246541245")
                .build();

        Pet alexsDog = Pet.builder()
                .name("Rock")
                .owner(owner2)
                .petType(savedDogPetType)
                .birthDate(LocalDate.now())
                .build();

        owner2.getPets().add(alexsDog);

        ownerService.save(owner2);

        log.info("Pets loaded!");
        log.info("Owners loaded!");

        Visit catVisit = Visit.builder()
                .pet(annsCat)
                .date(LocalDate.now())
                .description("Funny Kitty")
                .build();

        visitService.save(catVisit);

        log.info("Visits loaded!");

        Vet vet1 = new Vet();
        vet1.setFirstName("Mike");
        vet1.setLastName("Yalovoy");

        vet1.getSpecialities().add(savedDentistry);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Stas");
        vet2.setLastName("Commit");

        vet2.getSpecialities().add(savedSurgery);
        vet2.getSpecialities().add(savedRadiology);

        vetService.save(vet2);

        log.info("Vets loaded!");
    }

}
