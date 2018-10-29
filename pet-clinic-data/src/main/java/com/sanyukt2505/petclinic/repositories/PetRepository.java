package com.sanyukt2505.petclinic.repositories;

import com.sanyukt2505.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
