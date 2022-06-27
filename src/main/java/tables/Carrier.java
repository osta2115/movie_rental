package tables;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "carriers")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Carrier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 64, unique = true)
    private String description;
}
