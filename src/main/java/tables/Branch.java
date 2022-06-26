package tables;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "branches")
@Getter
@Setter
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@ToString
public class Branch {

    public Branch() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 64)
    private String name;

    @Column(name = "postal_code", length = 6, unique = true)
    private String postalCode;

    @Column(length = 64)
    private String adres;
}
