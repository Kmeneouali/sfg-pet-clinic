package com.km.springframework.bootstrap;

import com.km.springframework.model.*;
import com.km.springframework.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private  final OwnerService ownerService;

    private final VetService vetService;

    private final PetTypeService petTypeService;

    private SpecialtyService specialtyService;

    private VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if(count ==  0){
            LoadData();
        }


    }

    private void LoadData() {
        PetType dog=new PetType();
        dog.setName("Dog");
        PetType savedDogPetType=petTypeService.save(dog);

        PetType cat=new PetType();
        dog.setName("Cat");
        PetType savedCatPetType=petTypeService.save(cat);

        System.out.println("Loaded PetType ...");


        Speciality radiology=new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology=specialtyService.save(radiology);
        Speciality surgery=new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgery=specialtyService.save(surgery);
        Speciality dentistry=new Speciality();
        radiology.setDescription("Dentistry");
        Speciality savedDentistry=specialtyService.save(dentistry);

        Owner owner1= new Owner();
        owner1.setFirstName("khalled");
        owner1.setLastName("Meneouali");
        owner1.setAdress("123 Breklerl");
        owner1.setCity("Miami");
        owner1.setTelephone("123456789");
        Owner.builder().id(5L).city("eff").firstName("sdfvdsf").build();
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


        Pet fionasCat=new Pet();
        fionasCat.setPetType(savedCatPetType);
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setName("Just Cat");
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        Visit catVisit=new Visit();
        catVisit.setPet(fionasCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy ketty ");
        visitService.save(catVisit);

        System.out.println("Loaded Owners ...");

        Vet vet1= new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2= new Vet();
        vet2.setFirstName("Jessier");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgery);
        vet2.getSpecialities().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("Loaded Vets ..."+vetService.findAll().size());
    }
}
