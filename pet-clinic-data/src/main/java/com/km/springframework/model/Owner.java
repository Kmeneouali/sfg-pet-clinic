package com.km.springframework.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {
    @Column(name = "adress")
    private String adress;
    @Column(name = "city")
    private String city;
    @Column(name = "telephone")
    private String telephone;
    @OneToMany(cascade=CascadeType.ALL,mappedBy = "owner")
    private Set<Pet> pets= new HashSet<>();

    @Builder
    public Owner(Long id,String firstName,String lastName,String adress, String city, String telephone) {
        super(id,firstName,lastName);
        this.adress = adress;
        this.city = city;
        this.telephone = telephone;
    }


}
