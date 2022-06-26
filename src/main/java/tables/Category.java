package tables;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "categories")
@Getter
@Setter
@EqualsAndHashCode
public class Category {

    @Id
    private Integer id;

    @Column(length = 64)
    private String title;
}
