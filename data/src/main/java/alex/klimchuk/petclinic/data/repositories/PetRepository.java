package alex.klimchuk.petclinic.data.repositories;

import alex.klimchuk.petclinic.data.model.Pet;
import org.springframework.data.repository.CrudRepository;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
public interface PetRepository extends CrudRepository<Pet, Long> {

}
