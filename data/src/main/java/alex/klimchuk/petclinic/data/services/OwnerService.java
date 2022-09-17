package alex.klimchuk.petclinic.data.services;

import alex.klimchuk.petclinic.data.model.Owner;

import java.util.List;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

}
