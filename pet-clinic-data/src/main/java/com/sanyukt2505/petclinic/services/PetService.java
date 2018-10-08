package com.sanyukt2505.petclinic.services;

import com.sanyukt2505.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
