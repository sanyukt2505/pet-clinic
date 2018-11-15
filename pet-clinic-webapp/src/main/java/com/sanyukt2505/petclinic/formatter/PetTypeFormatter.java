package com.sanyukt2505.petclinic.formatter;

import com.sanyukt2505.petclinic.model.PetType;
import com.sanyukt2505.petclinic.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    final PetTypeService petTypeService;

    public PetTypeFormatter(final PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public String print(final PetType petType, final Locale locale) {
        return petType.getName();
    }

    @Override
    public PetType parse(final String text, final Locale locale) throws ParseException {
        final Collection<PetType> findPetTypes = petTypeService.findAll();

        for (final PetType type : findPetTypes) {
            if (type.getName().equals(text)) {
                return type;
            }
        }
        throw new ParseException("type not found: " + text, 0);
    }
}
