package alex.klimchuk.petclinic.web.formatters;

import alex.klimchuk.petclinic.data.model.PetType;
import alex.klimchuk.petclinic.data.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Iterator;
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

    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }

    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> findPetTypes = this.petTypeService.findAll();
        Iterator<PetType> var4 = findPetTypes.iterator();

        PetType type;
        do {
            if (!var4.hasNext()) {
                throw new ParseException("Type not found: " + text, 0);
            }

            type = var4.next();
        } while (!type.getName().equals(text));

        return type;
    }

}
