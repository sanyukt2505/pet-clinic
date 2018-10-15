package com.sanyukt2505.petclinic.services.map;

import com.sanyukt2505.petclinic.model.BaseEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(final ID id) {
        return map.get(id);
    }

    T save(final T object) {

        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        }
        else {
            throw new RuntimeException("Object to be saved cannot be null");
        }
        return object;
    }

    void deleteById(final ID id) {
        map.remove(id);
    }

    void delete(final T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {
        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        }
        catch (final NoSuchElementException e) {

            nextId = 1L;
        }
        return nextId;
    }
}
