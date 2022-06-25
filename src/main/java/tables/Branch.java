package tables;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "branches")
@Getter
@Setter
@EqualsAndHashCode
public class Branch {

    @Id
    private Integer id;

    @Column(length = 64)
    private String name;

    @Column(name = "postal_code", length = 6)
    private String postalCode;

    @Column(length = 64)
    private String adres;
}
