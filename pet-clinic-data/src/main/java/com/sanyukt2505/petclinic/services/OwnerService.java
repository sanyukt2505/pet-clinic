package com.sanyukt2505.petclinic.services;

import com.sanyukt2505.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
