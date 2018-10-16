package com.sanyukt2505.petclinic.services.map;

import com.sanyukt2505.petclinic.model.PetType;
import com.sanyukt2505.petclinic.services.PetTypeService;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(final PetType object) {
        return super.save(object);
    }

    @Override
    public void delete(final PetType object) {
        super.delete(object);
    }

    @Override
    public void deleteById(final Long id) {
        super.deleteById(id);
    }
}
