package uz.narzullayev.market.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
@NamedEntityGraph(name = Product.PHOTOS,
        attributeNodes = {@NamedAttributeNode("photos")}
)
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Transient
    private static final String sequence="product_sequence";
    @Transient
    public static final String PHOTOS="Product.photos";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = sequence)
    @SequenceGenerator(name = sequence, sequenceName = sequence, allocationSize = 1)
    @Column(name ="id")
    private Integer id;


    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_desc")
    private String description;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private Set<Photo> photos = new HashSet<>();


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",referencedColumnName = "id",insertable = false,updatable = false)
    private ProductCategory productCategory;

    @Column(name = "price")
    private Double price;

    public Product() {
    }

    public Product(Integer id, String productName,
                   String description,
                   Set<Photo> photos,
                   ProductCategory productCategory,
                   Double price) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.photos = photos;
        this.productCategory = productCategory;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<Photo> photos) {
        this.photos = photos;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
