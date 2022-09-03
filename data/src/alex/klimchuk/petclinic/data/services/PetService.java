package alex.klimchuk.petclinic.data.services;

import alex.klimchuk.petclinic.data.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Set<Pet> findAll();

    Pet save(Pet pet);

}
