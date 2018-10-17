package com.sanyukt2505.petclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {

    private Set<Speciality> specialitites = new HashSet<>();

    public Set<Speciality> getSpecialitites() {
        return specialitites;
    }

    public void setSpecialitites(final Set<Speciality> specialitites) {
        this.specialitites = specialitites;
    }
}
