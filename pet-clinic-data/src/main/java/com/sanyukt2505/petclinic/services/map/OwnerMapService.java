package com.sanyukt2505.petclinic.services.map;

import com.sanyukt2505.petclinic.model.Owner;
import com.sanyukt2505.petclinic.model.Pet;
import com.sanyukt2505.petclinic.services.OwnerService;
import com.sanyukt2505.petclinic.services.PetService;
import com.sanyukt2505.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(final PetTypeService petTypeService, final PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(final Owner object) {

        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("PetType is required");
                    }

                    if (pet.getId() == null) {
                        final Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
        }
        return super.save(object);
    }

    @Override
    public void deleteById(final Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(final Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findByLastName(final String lastName) {
        return this.findAll().stream().filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst().orElse(null);
    }
}
