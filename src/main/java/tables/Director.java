package tables;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "directors")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Column(name = "first_name", length = 64)
    private String firstName;

    @Column(name = "last_name", length = 64)
    private String lastName;
}
