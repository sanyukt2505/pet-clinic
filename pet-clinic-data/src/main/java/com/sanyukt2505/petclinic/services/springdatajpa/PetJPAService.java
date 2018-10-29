package com.sanyukt2505.petclinic.services.springdatajpa;

import com.sanyukt2505.petclinic.model.Pet;
import com.sanyukt2505.petclinic.repositories.PetRepository;
import com.sanyukt2505.petclinic.repositories.PetTypeRepository;
import com.sanyukt2505.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetJPAService implements PetService {

    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public PetJPAService(final PetRepository petRepository, final PetTypeRepository petTypeRepository) {
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<Pet> findAll() {
        final Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(final Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(final Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(final Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(final Long id) {
        petRepository.deleteById(id);
    }
}
