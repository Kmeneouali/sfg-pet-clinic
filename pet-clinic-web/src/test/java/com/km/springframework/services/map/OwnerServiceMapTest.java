package com.km.springframework.services.map;

import com.km.springframework.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {
    OwnerServiceMap ownerServiceMap;
    Long ownerId=1L;
    String lastName="khalled";

    @BeforeEach
    void setUp() {
        ownerServiceMap=new OwnerServiceMap(new PetServiceMap(),new PetTypeServiceMap()) ;
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet= ownerServiceMap.findAll();
        assertEquals(1,ownerSet.size());
    }
    @Test
    void findById() {
        Owner owner= ownerServiceMap.findById(ownerId);
        assertEquals(ownerId,owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id =2L;
        Owner owner=Owner.builder().id(id).build();
        ownerServiceMap.save(owner);
        assertEquals(id,owner.getId());
    }
    @Test
    void saveNoId() {
        Long id =2L;
        Owner saveOwner=ownerServiceMap.save(Owner.builder().build());

        assertNotNull(saveOwner);
        assertNotNull(saveOwner.getId());
    }


    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0,ownerServiceMap.findAll().size());
    }
    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertEquals(0,ownerServiceMap.findAll().size());

    }

    @Test
    void findByLastName() {
        Owner owner =ownerServiceMap.findByLastName(lastName);
        assertNotNull(owner);
        assertEquals(ownerId,owner.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner owner =ownerServiceMap.findByLastName("Omar");
        assertNull(owner);

    }
}