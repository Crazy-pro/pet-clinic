package alex.klimchuk.petclinic.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDate;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@Data
@Entity
@Builder
@AllArgsConstructor
public class Visit extends BaseEntity {

    private LocalDate date;
    private String description;
    private Pet pet;

}
