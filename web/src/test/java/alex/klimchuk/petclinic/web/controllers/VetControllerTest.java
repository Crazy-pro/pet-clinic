package alex.klimchuk.petclinic.web.controllers;

import alex.klimchuk.petclinic.data.model.Vet;
import alex.klimchuk.petclinic.data.services.VetService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VetControllerTest {

    @Mock
    private VetService vetService;

    @InjectMocks
    private VetController vetController;

    @Test
    public void testGetAllInJson() {
        Set<Vet> vets = Set.of(Vet.builder().build(), Vet.builder().build());
        when(vetService.findAll()).thenReturn(vets);

        Set<Vet> result = vetController.getAllInJson();

        assertThat(result).isEqualTo(vets);
        verify(vetService, times(1)).findAll();
    }

    @Test
    public void testFindAll() {
        Set<Vet> vets = new HashSet<>();
        vets.add(Vet.builder().id(1L).build());
        vets.add(Vet.builder().id(2L).build());

        when(vetService.findAll()).thenReturn(vets);

        Set<Vet> result = vetController.getAllInJson();

        assertThat(result).hasSize(2);
        verify(vetService, times(1)).findAll();
    }

}
