package alex.klimchuk.petclinic.data.repositories;

import alex.klimchuk.petclinic.data.model.Visit;
import org.springframework.data.repository.CrudRepository;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
public interface VisitRepository extends CrudRepository<Visit, Long> {

}
