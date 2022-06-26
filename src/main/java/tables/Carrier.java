package tables;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "carriers")
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Builder
@ToString
public class Carrier {

    public Carrier (){    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 64,unique = true)
    private String description;

    @OneToMany (mappedBy = "carrier", cascade = CascadeType.ALL)
    private Set<Product> products;
}
