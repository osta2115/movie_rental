package tables;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "branches")
@Getter
@Setter
@EqualsAndHashCode
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 64)
    private String name;

    @Column(name = "postal_code", length = 6)
    private String postalCode;

    @Column(length = 64)
    private String adres;
}
