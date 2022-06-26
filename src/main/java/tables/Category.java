package tables;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
@Getter
@Setter
//@EqualsAndHashCode
@AllArgsConstructor
@Builder
@ToString
public class Category {

    public Category (){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 64,unique = true)
    private String title;

    @OneToMany (mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = false)
    private Set<Product> products;
}
