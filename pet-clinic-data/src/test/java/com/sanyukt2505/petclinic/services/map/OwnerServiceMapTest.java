package com.sanyukt2505.petclinic.services.map;

import com.sanyukt2505.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class OwnerServiceMapTest {

    private OwnerMapService ownerMapService;
    final Long ownerId = 1L;
    final String lastName = "Jack";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetServiceMap());

        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        final Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        final Owner owner = ownerMapService.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {
        final Long id = 2L;
        final Owner owner = Owner.builder().id(id).build();
        final Owner savedOwner = ownerMapService.save(owner);

        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        final Owner owner = Owner.builder().build();
        final Owner savedOwner = ownerMapService.save(owner);

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        final Owner owner = ownerMapService.findByLastName(lastName);
        assertEquals(ownerId, owner.getId());

    }

    @Test
    void findByLastNameNotFound() {
        final Owner owner = ownerMapService.findByLastName("test");
        assertNull(owner);
    }

}