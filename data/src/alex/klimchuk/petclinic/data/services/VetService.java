package alex.klimchuk.petclinic.data.services;

import alex.klimchuk.petclinic.data.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Set<Vet> findAll();

    Vet save(Vet vet);

}
