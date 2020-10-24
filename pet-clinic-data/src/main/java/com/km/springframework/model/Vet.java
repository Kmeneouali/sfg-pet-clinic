package com.km.springframework.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "vets")
public class Vet extends Person {
@ManyToMany
@JoinTable(name = "vert_specialities",joinColumns = @JoinColumn(name = "vert_id"),
inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities= new HashSet<>();

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
