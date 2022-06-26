package tables;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "carriers")
@Getter
@Setter
@EqualsAndHashCode
public class Carrier {

    @Id
    private Integer id;

    @Column(length = 64)
    private String description;
}
