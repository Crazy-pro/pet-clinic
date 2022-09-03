package main.java.alex.klimchuk.petclinic.data.services.map;

import main.java.alex.klimchuk.petclinic.data.model.Vet;
import main.java.alex.klimchuk.petclinic.data.services.CrudService;

import java.util.Set;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */

public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(), vet);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

}
