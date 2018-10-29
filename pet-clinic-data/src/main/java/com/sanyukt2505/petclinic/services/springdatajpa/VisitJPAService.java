package com.sanyukt2505.petclinic.services.springdatajpa;

import com.sanyukt2505.petclinic.model.Visit;
import com.sanyukt2505.petclinic.repositories.VisitRepository;
import com.sanyukt2505.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitJPAService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitJPAService(final VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        final Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(final Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(final Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(final Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(final Long id) {
        visitRepository.deleteById(id);
    }
}
