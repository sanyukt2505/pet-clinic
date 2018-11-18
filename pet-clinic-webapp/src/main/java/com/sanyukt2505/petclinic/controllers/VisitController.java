package com.sanyukt2505.petclinic.controllers;

import com.sanyukt2505.petclinic.model.Pet;
import com.sanyukt2505.petclinic.model.Visit;
import com.sanyukt2505.petclinic.services.PetService;
import com.sanyukt2505.petclinic.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class VisitController {
    private final PetService petService;
    private final VisitService visitService;

    public VisitController(final PetService petService, final VisitService visitService) {
        this.petService = petService;
        this.visitService = visitService;
    }

    @InitBinder
    public void setAllowedFields(final WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    /**
     * Called before each and every @RequestMapping annotated method.
     * 2 goals:
     * - Make sure we always have fresh data
     * - Since we do not use the session scope, make sure that Pet object always has an id
     * (Even though id is not part of the form fields)
     *
     * @param petId
     * @return Pet
     */
    @ModelAttribute("visit")
    public Visit loadPetWithVisit(@PathVariable("petId") final Long petId, final Model model) {
        final Pet pet = petService.findById(petId);
        model.addAttribute("pet", pet);
        final Visit visit = new Visit();
        pet.getVisits().add(visit);
        visit.setPet(pet);
        return visit;
    }

    // Spring MVC calls method loadPetWithVisit(...) before initNewVisitForm is called
    @GetMapping("/owners/*/pets/{petId}/visits/new")
    public String initNewVisitForm(@PathVariable("petId") final Long petId, final Model model) {
        return "pets/createOrUpdateVisitForm";
    }

    // Spring MVC calls method loadPetWithVisit(...) before processNewVisitForm is called
    @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String processNewVisitForm(@Valid final Visit visit, final BindingResult result) {
        if (result.hasErrors()) {
            return "pets/createOrUpdateVisitForm";
        } else {
            visitService.save(visit);
            return "redirect:/owners/{ownerId}";
        }
    }
}
