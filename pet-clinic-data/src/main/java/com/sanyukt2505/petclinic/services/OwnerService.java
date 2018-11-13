package com.sanyukt2505.petclinic.services;

import com.sanyukt2505.petclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String s);
}
