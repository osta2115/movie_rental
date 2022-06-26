package tables;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pegi_categories")
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Builder
@ToString
public class PegiCategory {

    public PegiCategory() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 64, unique = true)
    private String title;

    @OneToMany(mappedBy = "pegiCategory", cascade = CascadeType.ALL)
    private Set<Product> products;
}
