package alex.klimchuk.petclinic.data.repositories;

import alex.klimchuk.petclinic.data.model.PetType;
import org.springframework.data.repository.CrudRepository;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
