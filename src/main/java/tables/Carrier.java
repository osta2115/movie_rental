package tables;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "carriers")
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Builder
public class Carrier {

    public Carrier (){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 64,unique = true)
    private String description;
}
