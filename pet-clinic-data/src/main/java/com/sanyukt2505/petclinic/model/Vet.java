package com.sanyukt2505.petclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialities", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialitites = new HashSet<>();

    public Set<Speciality> getSpecialitites() {
        return specialitites;
    }

    public void setSpecialitites(final Set<Speciality> specialitites) {
        this.specialitites = specialitites;
    }
}
