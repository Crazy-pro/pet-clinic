package main.java.alex.klimchuk.petclinic.data.services.map;

import main.java.alex.klimchuk.petclinic.data.model.Owner;
import main.java.alex.klimchuk.petclinic.data.services.OwnerService;

import java.util.Set;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String name) {
        return null;
    }

    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(), owner);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

}
