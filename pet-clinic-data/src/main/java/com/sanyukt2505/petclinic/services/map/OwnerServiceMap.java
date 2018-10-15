package com.sanyukt2505.petclinic.services.map;

import com.sanyukt2505.petclinic.model.Owner;
import com.sanyukt2505.petclinic.services.OwnerService;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(final Owner object) {
        return super.save(object);
    }

    @Override
    public void deleteById(final Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(final Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findByLastName(final String lastName) {
        return null;
    }
}
