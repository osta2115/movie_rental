package tables;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "directors")
@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Director {

    public Director() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Column(name = "first_name", length = 64)
    private String firstName;

    @Column(name = "last_name", length = 64)
    private String lastName;
}
