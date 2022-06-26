package tables;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "products")
@EqualsAndHashCode
public class Product {
    @Id
    private Integer id;

    @Column (length = 64)
    private String title;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;

    @ManyToOne
    @JoinColumn(name = "pegi_category_id")
    private PegiCategory pegiCategoroy;

    @ManyToOne
    @JoinColumn(name = "carrier_id")
    private Carrier carrier;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;
}
