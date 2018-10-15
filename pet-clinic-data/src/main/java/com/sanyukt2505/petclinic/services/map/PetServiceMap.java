package com.sanyukt2505.petclinic.services.map;

import com.sanyukt2505.petclinic.model.Pet;
import com.sanyukt2505.petclinic.services.PetService;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(final Pet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void deleteById(final Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(final Pet object) {
        super.delete(object);
    }
}
