package main.java.alex.klimchuk.petclinic.data.services.map;

import main.java.alex.klimchuk.petclinic.data.model.Pet;
import main.java.alex.klimchuk.petclinic.data.services.CrudService;

import java.util.Set;

/**
 * Copyright Alex Klimchuk (c) 2022.
*/
public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(), pet);
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

}