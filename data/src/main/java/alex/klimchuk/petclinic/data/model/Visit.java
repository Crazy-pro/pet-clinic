package alex.klimchuk.petclinic.data.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "visits")
public class Visit extends BaseEntity {

    private LocalDate date;
    private String description;
    private Pet pet;

}
