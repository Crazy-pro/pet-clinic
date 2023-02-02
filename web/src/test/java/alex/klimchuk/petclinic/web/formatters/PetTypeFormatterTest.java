package alex.klimchuk.petclinic.web.formatters;

import alex.klimchuk.petclinic.data.model.PetType;
import alex.klimchuk.petclinic.data.services.PetTypeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PetTypeFormatterTest {

    @Mock
    private PetTypeService petTypeService;

    @InjectMocks
    private PetTypeFormatter petTypeFormatter;

    @Test
    public void testPrintShouldReturnTheNameOfThePetType() {
        PetType petType = PetType.builder().name("Dog").build();
        Locale locale = Locale.ENGLISH;

        String result = petTypeFormatter.print(petType, locale);

        assertThat(result).isEqualTo("Dog");
    }

    @Test
    public void testParseWhenNameIsNotFoundThenThrowException() {
        String name = "name";
        Locale locale = Locale.ENGLISH;

        when(petTypeService.findAll()).thenReturn(new HashSet<>());

        ParseException exception = assertThrows(ParseException.class, () -> petTypeFormatter.parse(name, locale));

        assertThat(exception.getMessage()).isEqualTo("Type not found: " + name);
    }

    @Test
    public void testParseWhenNameIsFoundThenReturnPetType() throws ParseException {
        String name = "Dog";
        PetType petType = PetType.builder().name(name).build();

        Set<PetType> petTypes = new HashSet<>();
        petTypes.add(petType);

        when(petTypeService.findAll()).thenReturn(petTypes);

        PetType result = petTypeFormatter.parse(name, Locale.ENGLISH);

        assertThat(result).isEqualTo(petType);
    }

}
