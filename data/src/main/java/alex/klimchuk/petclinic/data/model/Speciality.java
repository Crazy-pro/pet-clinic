package alex.klimchuk.petclinic.data.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "specialities")
public class Speciality extends BaseEntity {

    private String description;

}
