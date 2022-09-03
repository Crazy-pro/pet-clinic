package alex.klimchuk.petclinic.data.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright Alex Klimchuk (c) 2022.
*/
@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public boolean isNew() {
        return this.id == null;
    }

}
