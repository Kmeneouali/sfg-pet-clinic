package com.km.springframework.bootstrap;

import com.km.springframework.model.Owner;
import com.km.springframework.model.Pet;
import com.km.springframework.model.PetType;
import com.km.springframework.model.Vet;
import com.km.springframework.services.OwnerService;
import com.km.springframework.services.PetTypeService;
import com.km.springframework.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private  final OwnerService ownerService;

    private final VetService vetService;

    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }





    @Override
    public void run(String... args) throws Exception {

        PetType dog=new PetType();
        dog.setName("Dog");
        PetType savedDogPetType=petTypeService.save(dog);

        PetType cat=new PetType();
        dog.setName("Cat");
        PetType savedCatPetType=petTypeService.save(cat);

        System.out.println("Loaded PetType ...");

        Owner owner1= new Owner();
        owner1.setFirstName("khalled");
        owner1.setLastName("Meneouali");
        owner1.setAdress("123 Breklerl");
        owner1.setCity("Miami");
        owner1.setTelephone("123456789");

        Pet mikesPet=new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2= new Owner();
        owner2.setFirstName("Omar");
        owner2.setLastName("Meneouali");
        owner2.setAdress("123 Breklerl");
        owner2.setCity("Miami");
        owner2.setTelephone("123456789");


        Pet FionasCat=new Pet();
        FionasCat.setPetType(savedCatPetType);
        FionasCat.setOwner(owner2);
        FionasCat.setBirthDate(LocalDate.now());
        FionasCat.setName("Just Cat");
        owner2.getPets().add(FionasCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners ...");

        Vet vet1= new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2= new Vet();
        vet2.setFirstName("Jessier");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets ..."+vetService.findAll().size());
    }
}
