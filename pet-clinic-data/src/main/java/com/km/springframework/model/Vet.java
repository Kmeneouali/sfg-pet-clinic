package com.km.springframework.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@Table(name = "vets")
public class Vet extends Person {
@ManyToMany
@JoinTable(name = "vert_specialities",joinColumns = @JoinColumn(name = "vert_id"),
inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities= new HashSet<>();

}
