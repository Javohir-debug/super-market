package uz.narzullayev.market.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_category")
public class ProductCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Transient
    private static final String sequence="product_category_sequence";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = sequence)
    @SequenceGenerator(name = sequence, sequenceName = sequence, allocationSize = 1)
    @Column(name ="id")
    private Integer id;

    @Column(name = "category_name",unique = true)
    private String categoryName;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
