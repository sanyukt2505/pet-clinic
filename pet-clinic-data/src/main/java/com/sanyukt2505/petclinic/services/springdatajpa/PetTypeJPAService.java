package com.sanyukt2505.petclinic.services.springdatajpa;

import com.sanyukt2505.petclinic.model.PetType;
import com.sanyukt2505.petclinic.repositories.PetTypeRepository;
import com.sanyukt2505.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeJPAService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeJPAService(final PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        final Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(final Long id) {
        return petTypeRepository.findById(id).orElse(null);
    }

    @Override
    public PetType save(final PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(final PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(final Long id) {
        petTypeRepository.deleteById(id);
    }
}
