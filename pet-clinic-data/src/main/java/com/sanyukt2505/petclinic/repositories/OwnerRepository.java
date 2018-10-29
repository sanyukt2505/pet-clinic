package com.sanyukt2505.petclinic.repositories;

import com.sanyukt2505.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(final String lastName);
}
