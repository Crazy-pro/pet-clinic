package alex.klimchuk.petclinic.data.services.map;

import alex.klimchuk.petclinic.data.model.Speciality;
import alex.klimchuk.petclinic.data.model.Pet;
import alex.klimchuk.petclinic.data.services.SpecialityService;
import alex.klimchuk.petclinic.data.services.PetService;
import alex.klimchuk.petclinic.data.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@Service
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Speciality save(Speciality speciality) {
            return super.save(speciality);
    }

    @Override
    public void delete(Speciality speciality) {
        super.delete(speciality);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

}
