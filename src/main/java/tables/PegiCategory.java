package tables;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "pegi_categories")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PegiCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 64, unique = true)
    private String title;
}
