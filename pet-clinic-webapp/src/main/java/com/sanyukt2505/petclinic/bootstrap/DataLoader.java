package com.sanyukt2505.petclinic.bootstrap;

import com.sanyukt2505.petclinic.model.*;
import com.sanyukt2505.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(final OwnerService ownerService, final VetService vetService, final PetTypeService petTypeService,
                      final PetService petService, final SpecialityService specialityService, final VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(final String... args) throws Exception {

        if (petService.findAll().size() == 0) {
            createData();
        }
    }

    private void createData() {
        final PetType dog = new PetType();
        dog.setName("Dog");
        final PetType savedDogPetType = petTypeService.save(dog);

        final PetType cat = new PetType();
        cat.setName("Cat");
        final PetType savedCatPetType = petTypeService.save(cat);

        final Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        final Speciality savedRadiology = specialityService.save(radiology);

        final Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        final Speciality savedSurgery = specialityService.save(surgery);

        final Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        final Speciality savedDentistry = specialityService.save(dentistry);

        final Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Gibson");
        owner1.setAddress("123 Castro St");
        owner1.setCity("San Jose");
        owner1.setTelephone("1232123214");

        final Pet johnPet = new Pet();
        johnPet.setPetType(savedDogPetType);
        johnPet.setOwner(owner1);
        johnPet.setName("Jackie");
        johnPet.setBirthDate(LocalDate.now());

        owner1.getPets().add(johnPet);
        ownerService.save(owner1);

        final Owner owner2 = new Owner();
        owner2.setFirstName("Michel");
        owner2.setLastName("Stinson");
        owner2.setAddress("456 Castro St");
        owner2.setCity("San Jose");
        owner2.setTelephone("9992221342");

        final Pet michelCat = new Pet();
        michelCat.setPetType(cat);
        michelCat.setOwner(owner2);
        michelCat.setName("Lucie");
        michelCat.setBirthDate(LocalDate.now());

        owner2.getPets().add(michelCat);
        ownerService.save(owner2);

        final Visit catVisit = new Visit();
        catVisit.setDate(LocalDate.now());
        catVisit.setPet(michelCat);
        catVisit.setDescription("Cold");
        visitService.save(catVisit);

        final Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialitites().add(savedRadiology);
        vetService.save(vet1);

        final Vet vet2 = new Vet();
        vet2.setFirstName("Rudy");
        vet2.setLastName("Ann");
        vet2.getSpecialitites().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("Loaded data.....");
    }
}
