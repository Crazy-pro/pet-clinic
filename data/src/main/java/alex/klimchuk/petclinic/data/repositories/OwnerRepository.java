package alex.klimchuk.petclinic.data.repositories;

import alex.klimchuk.petclinic.data.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

}
