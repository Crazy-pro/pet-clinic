package alex.klimchuk.petclinic.data.services.map;

import alex.klimchuk.petclinic.data.model.Visit;
import alex.klimchuk.petclinic.data.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

import static java.util.Objects.isNull;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {
        if (isNull(visit.getPet()) ||
                isNull(visit.getPet().getId())) {
            throw new NullPointerException("Fields cannot be null. Invalid Visit!");
        }
        return super.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

}
