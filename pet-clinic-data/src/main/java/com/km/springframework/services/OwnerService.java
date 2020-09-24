package com.km.springframework.services;

import com.km.springframework.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastName);
    Owner findByLastId(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}
