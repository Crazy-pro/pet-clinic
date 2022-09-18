package alex.klimchuk.petclinic.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_new")
    public boolean isNew() {
        return this.id == null;
    }

}
