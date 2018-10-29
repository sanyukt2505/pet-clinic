package com.sanyukt2505.petclinic.repositories;

import com.sanyukt2505.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
