package alex.klimchuk.petclinic.data.services.map;

import alex.klimchuk.petclinic.data.model.Speciality;
import alex.klimchuk.petclinic.data.model.Vet;
import alex.klimchuk.petclinic.data.services.SpecialityService;
import alex.klimchuk.petclinic.data.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

import static java.util.Objects.isNull;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
        if (!vet.getSpecialities().isEmpty()) {
            vet.getSpecialities().forEach(speciality -> {
                if (isNull(speciality.getId())) {
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

}
