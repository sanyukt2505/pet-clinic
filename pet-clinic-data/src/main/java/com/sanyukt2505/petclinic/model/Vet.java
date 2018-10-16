package com.sanyukt2505.petclinic.model;

import java.util.Set;

public class Vet extends Person {

    private Set<Speciality> specialitites;

    public Set<Speciality> getSpecialitites() {
        return specialitites;
    }

    public void setSpecialitites(final Set<Speciality> specialitites) {
        this.specialitites = specialitites;
    }
}
