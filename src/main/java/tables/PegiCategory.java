package tables;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pegi_categories")
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class PegiCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 64, unique = true)
    private String title;
}
