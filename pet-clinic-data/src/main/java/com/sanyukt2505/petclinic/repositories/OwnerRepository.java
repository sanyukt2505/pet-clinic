package com.sanyukt2505.petclinic.repositories;

import com.sanyukt2505.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(final String lastName);

    List<Owner> findAllByLastName(final String lastName);
}
