package tables;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pegi_categories")
@Getter
@Setter
@EqualsAndHashCode
public class PegiCategory {
    @Id
    private Integer id;

    @Column(length = 64)
    private String title;
}
