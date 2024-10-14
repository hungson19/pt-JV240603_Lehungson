package exam_javacore_webapp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", length = 100, unique = true, nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @OneToMany(mappedBy = "category")
    private Set<Product> products;
}
