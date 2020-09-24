package com.km.springframework.services;

import com.km.springframework.model.Owner;
import com.km.springframework.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findByLastId(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();

}
