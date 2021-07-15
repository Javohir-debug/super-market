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
public class Product  implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String PHOTOS ="Product.photos";
    @Transient
    private static final String sequence="product_sequence";


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = sequence)
    @SequenceGenerator(name = sequence, sequenceName = sequence, allocationSize = 1)
    @Column(name ="id")
    private Integer id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",referencedColumnName = "id",updatable = false,insertable = false)
    private ProductCategory category;

    @Column(name = "category_id")
    private Integer categoryId;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "product",orphanRemoval = true)
    private Set<Photo> photos=new HashSet<>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static String getSequence() {
        return sequence;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public Set<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<Photo> photos) {
        this.photos = photos;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }
}
