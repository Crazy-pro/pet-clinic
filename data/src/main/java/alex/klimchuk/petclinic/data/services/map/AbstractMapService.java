package alex.klimchuk.petclinic.data.services.map;

import alex.klimchuk.petclinic.data.model.BaseEntity;

import java.util.*;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {

        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null!");
        }

        return object;
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    private Long getNextId() {

        Long nextId = null;

        try {
            nextId = map.keySet().size() + 1L;
        } catch (NoSuchElementException exception) {
            nextId = 1L;
        }

        return nextId;
    }

}
