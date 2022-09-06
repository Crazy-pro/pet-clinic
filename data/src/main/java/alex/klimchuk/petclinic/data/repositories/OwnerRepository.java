package alex.klimchuk.petclinic.data.repositories;

import alex.klimchuk.petclinic.data.model.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

}
