package com.km.springframework.services;

import com.km.springframework.model.Pet;
import com.km.springframework.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findByLastId(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();

}
