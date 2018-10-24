package com.sanyukt2505.petclinic.controllers;

import com.sanyukt2505.petclinic.services.OwnerService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(final OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({ "", "/", "/index", "/index.html" })
    public String listOwners(final Model model) {

        model.addAttribute("owners", ownerService.findAll());
        return "owner/index";
    }

    @RequestMapping({ "/find" })
    public String findOwners() {

        return "comingsoon";
    }
}
