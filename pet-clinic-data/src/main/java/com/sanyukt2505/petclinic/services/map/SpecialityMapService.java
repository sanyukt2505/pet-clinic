package com.sanyukt2505.petclinic.services.map;

import com.sanyukt2505.petclinic.model.Speciality;
import com.sanyukt2505.petclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public Speciality save(final Speciality object) {
        return super.save(object);
    }

    @Override
    public void deleteById(final Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(final Speciality object) {
        super.delete(object);
    }
}
