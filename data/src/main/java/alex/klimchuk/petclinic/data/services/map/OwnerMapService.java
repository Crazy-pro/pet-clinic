package alex.klimchuk.petclinic.data.services.map;

import alex.klimchuk.petclinic.data.model.Owner;
import alex.klimchuk.petclinic.data.model.Pet;
import alex.klimchuk.petclinic.data.services.OwnerService;
import alex.klimchuk.petclinic.data.services.PetService;
import alex.klimchuk.petclinic.data.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().contains(lastName))
                .collect(Collectors.toList());
    }

    @Override
    public Owner save(Owner owner) {
        if (nonNull(owner)) {
            if (nonNull(owner.getPets())) {
                owner.getPets().forEach(pet -> {
                    if (nonNull(pet.getPetType())) {
                        if (isNull(pet.getPetType().getId())) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new NullPointerException("Pet Type is required!");
                    }
                    if (isNull(pet.getId())) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(owner);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

}
