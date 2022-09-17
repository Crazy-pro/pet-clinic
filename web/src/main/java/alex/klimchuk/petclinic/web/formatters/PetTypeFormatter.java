package alex.klimchuk.petclinic.web.formatters;

import alex.klimchuk.petclinic.data.model.PetType;
import alex.klimchuk.petclinic.data.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> petTypes = petTypeService.findAll();

        for (PetType type : petTypes) {
            if (type.getName().equals(text)) {
                return type;
            }
        }

        throw new ParseException("Type not found: " + text, 0);
    }

}
