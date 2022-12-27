package alex.klimchuk.petclinic.data.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

import static java.util.Objects.isNull;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_new")
    public boolean isNew() {
        return isNull(this.id);
    }

}
