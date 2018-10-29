package com.sanyukt2505.petclinic.services.map;

import com.sanyukt2505.petclinic.model.Speciality;
import com.sanyukt2505.petclinic.model.Vet;
import com.sanyukt2505.petclinic.services.SpecialityService;
import com.sanyukt2505.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    final private SpecialityService specialityService;

    public VetServiceMap(final SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(final Vet object) {
        if (object != null) {
            if (object.getSpecialitites().size() > 0) {
                object.getSpecialitites().forEach(speciality -> {
                    if (speciality.getId() == null) {
                        final Speciality savedSpeciality = specialityService.save(speciality);
                        speciality.setId(savedSpeciality.getId());
                    }
                });
            }
        }
        return super.save(object);
    }

    @Override
    public void deleteById(final Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(final Vet object) {
        super.delete(object);
    }
}
