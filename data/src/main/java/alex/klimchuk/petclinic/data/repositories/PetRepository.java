package alex.klimchuk.petclinic.data.repositories;

import alex.klimchuk.petclinic.data.model.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {

}
