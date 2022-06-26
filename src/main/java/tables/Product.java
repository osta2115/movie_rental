package tables;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "products")
@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 64)
    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "director_id")
    private Director director;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pegi_category_id")
    private PegiCategory pegiCategory;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carrier_id")
    private Carrier carrier;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @Column (name = "release_date")
    private LocalDate releaseDate;
}
