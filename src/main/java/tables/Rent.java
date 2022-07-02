package tables;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;



@Getter
@Setter
@EqualsAndHashCode
@Table(name = "rents")
@Entity
public class Rent {

    public Rent() {

    }

    public Rent(Integer id, Product product, Client client, LocalDate rentDate, LocalDate returnDate) {
        this.id = id;
        this.product = product;
        this.client = client;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "rentDate")
    private LocalDate rentDate;

    @Column(name = "returnDate")
    private LocalDate returnDate;

}

