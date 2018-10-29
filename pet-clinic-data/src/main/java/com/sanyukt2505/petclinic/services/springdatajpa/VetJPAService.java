package com.sanyukt2505.petclinic.services.springdatajpa;

import com.sanyukt2505.petclinic.model.Vet;
import com.sanyukt2505.petclinic.repositories.SpecialityRepository;
import com.sanyukt2505.petclinic.repositories.VetRepository;
import com.sanyukt2505.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetJPAService implements VetService {

    private final VetRepository vetRepository;
    private final SpecialityRepository specialityRepository;

    public VetJPAService(final VetRepository vetRepository, final SpecialityRepository specialityRepository) {
        this.vetRepository = vetRepository;
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Vet> findAll() {
        final Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(final Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(final Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(final Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(final Long id) {
        vetRepository.deleteById(id);
    }
}
