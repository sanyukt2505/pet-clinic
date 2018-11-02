package com.sanyukt2505.petclinic.services.springdatajpa;

import com.sanyukt2505.petclinic.model.Owner;
import com.sanyukt2505.petclinic.repositories.OwnerRepository;
import com.sanyukt2505.petclinic.repositories.PetRepository;
import com.sanyukt2505.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceTest {

    public static String LAST_NAME = "Lee";
    @Mock
    private OwnerRepository ownerRepository;
    @Mock
    private PetRepository petRepository;
    @Mock
    private PetTypeRepository petTypeRepository;

    @InjectMocks
    private OwnerJPAService ownerJPAService;

    private Owner returnedOwner;

    @BeforeEach
    void setUp() {
        returnedOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(returnedOwner);

        final Owner owner = ownerJPAService.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, owner.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        final Set<Owner> owners = new HashSet<>();
        owners.add(returnedOwner);

        when(ownerRepository.findAll()).thenReturn(owners);
        final Set<Owner> ownerSet = ownerJPAService.findAll();
        assertNotNull(ownerSet);
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnedOwner));

        final Owner owner = ownerJPAService.findById(returnedOwner.getId());
        assertEquals(returnedOwner.getId(), owner.getId());
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(returnedOwner);

        final Owner owner = Owner.builder().id(1L).lastName(LAST_NAME).build();
        final Owner savedOwner = ownerJPAService.save(owner);

        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerJPAService.delete(returnedOwner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerJPAService.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }

}