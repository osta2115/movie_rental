package tables;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.Date;



@Getter
@Setter
@EqualsAndHashCode
@Table(name = "rents")
@Entity
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "rentDate")
    private Date rentDate;

    @Column(name = "returnDate")
    private Date returnDate;

}

