package alex.klimchuk.petclinic.data.services;

import alex.klimchuk.petclinic.data.model.Owner;

/**
 * Copyright Alex Klimchuk (c) 2022.
*/
public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
