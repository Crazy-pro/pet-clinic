package alex.klimchuk.petclinic.data.services;

import java.util.Set;

/**
 * Copyright Alex Klimchuk (c) 2022.
*/
public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T t);

    void delete(T t);

    void deleteById(ID id);

}
