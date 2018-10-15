package com.sanyukt2505.petclinic.bootstrap;

import com.sanyukt2505.petclinic.model.Owner;
import com.sanyukt2505.petclinic.model.Vet;
import com.sanyukt2505.petclinic.services.OwnerService;
import com.sanyukt2505.petclinic.services.VetService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(final OwnerService ownerService, final VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(final String... args) throws Exception {

        final Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Gibson");
        ownerService.save(owner1);

        final Owner owner2 = new Owner();
        owner2.setFirstName("Michel");
        owner2.setLastName("Stinson");
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
