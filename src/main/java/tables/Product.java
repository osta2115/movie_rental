package tables;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "products")
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Product {

    public Product(){    }

    public Product(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Product(Integer id, String title, LocalDate releaseDate) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public Product(Integer id, String title, Category category, LocalDate releaseDate) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.releaseDate = releaseDate;
    }

    public Product(Integer id, String title, Category category, Director director, PegiCategory pegiCategory, Carrier carrier, Branch branch, LocalDate releaseDate) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.director = director;
        this.pegiCategory = pegiCategory;
        this.carrier = carrier;
        this.branch = branch;
        this.releaseDate = releaseDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 64)
    private String title;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "director_id")
    private Director director;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "pegi_category_id")
    private PegiCategory pegiCategory;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "carrier_id")
    private Carrier carrier;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @Column (name = "release_date")
    private LocalDate releaseDate;

    @Override
    public String toString() {
        return "Product " +
                "id = " + id +
                " title= '" + title + '\'' +
                ", releaseDate = " + releaseDate +
                ", category = " + category.getTitle() +
                ", director = " + director.getFirstName() + " " +director.getLastName() +
                ", pegiCategory = " + pegiCategory.getTitle() +
                ", carrier = " + carrier.getDescription() +
                ", available in = " + branch.getName();
    }
}
