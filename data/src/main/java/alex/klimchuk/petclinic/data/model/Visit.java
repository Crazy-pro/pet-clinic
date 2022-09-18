package alex.klimchuk.petclinic.data.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "visits")
public class Visit extends BaseEntity {

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @ManyToOne()
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public LocalDate getDate() {
        return date;
    }

}
