package alex.klimchuk.petclinic.data.services;

import alex.klimchuk.petclinic.data.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String name);

    Owner findById(Long id);

    Set<Owner> findAll();

    Owner save(Owner owner);

}
