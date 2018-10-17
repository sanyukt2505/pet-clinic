package com.sanyukt2505.petclinic.bootstrap;

import com.sanyukt2505.petclinic.model.Owner;
import com.sanyukt2505.petclinic.model.Pet;
import com.sanyukt2505.petclinic.model.PetType;
import com.sanyukt2505.petclinic.model.Vet;
import com.sanyukt2505.petclinic.services.OwnerService;
import com.sanyukt2505.petclinic.services.PetService;
import com.sanyukt2505.petclinic.services.PetTypeService;
import com.sanyukt2505.petclinic.services.VetService;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;

    public DataLoader(final OwnerService ownerService, final VetService vetService, final PetTypeService petTypeService,
            final PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public void run(final String... args) throws Exception {

        final PetType dog = new PetType();
        dog.setName("Dog");
        final PetType savedDogPetType = petTypeService.save(dog);

        final PetType cat = new PetType();
        cat.setName("Cat");
        final PetType savedCatPetType = petTypeService.save(cat);

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
        ownerService.save(owner2);

        final Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        final Vet vet2 = new Vet();
        vet2.setFirstName("Rudy");
        vet2.setLastName("Ann");
        vetService.save(vet2);

        System.out.println("Loaded data.....");
    }
}
