package uz.narzullayev.market.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import uz.narzullayev.market.MainTest;
import uz.narzullayev.market.entity.Photo;
import uz.narzullayev.market.entity.Product;
import uz.narzullayev.market.entity.ProductCategory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ProductServiceTest implements MainTest {

    private final ProductService productService;
    private final ProductCategoryService productCategoryService;
    private final PhotoService photoService;
    private final LoadService loadService;
    private Product product;
    private Set<Photo> photos;

    @Autowired
    public ProductServiceTest(ProductService productService,
                              ProductCategoryService productCategoryService,
                              PhotoService photoService, LoadService loadService) {
        this.productService = productService;
        this.productCategoryService = productCategoryService;
        this.photoService = photoService;
        this.loadService = loadService;
    }





    @BeforeEach
    void setUp() {
        ProductCategory productCategory=new ProductCategory();
        productCategory.setId(1);
        productCategory.setCategoryName("Elektronika");
        ProductCategory category = productCategoryService.save(productCategory);


        Product product = new Product();
        product.setProductName("Hp");
        product.setPrice(9_000_000.0);
        product.setId(1);
        product.setDescription("Eng arzon va sifatli");
        product.setProductCategory(category);

        Photo photo1 = new Photo();
        photo1.setId(1);
        photo1.setExtension("jpeg");
        photo1.setFileSize(20100);
        photo1.setProduct(product);

        Photo photo2 = new Photo();
        photo2.setId(2);
        photo2.setExtension("png");
        photo2.setFileSize(12000);
        photo2.setProduct(product);

        this.photos = new HashSet<>(Arrays.asList(photo2, photo1));
        this.product = product;
    }

    @Test
    @Order(1)
    @DisplayName("Yangi mahsulot qo'shish")
    void save() {
        assertNotNull(product);
        assertNotNull(productService);
        product.setPhotos(photos);
        productService.save(product);



    }

    @Test
    @Order(2)
    @DisplayName("Loading fetch eager and lazy")
    @Transactional
    void findById(){
        Product byId = productService.findById(1);
     //   byId = loadService.lazy_to_eager(Product.class, Product.PHOTOS, byId.getId());
        Set<Photo> photos = byId.getPhotos();
        assertEquals(Objects.requireNonNull(byId).getId(),1);
    }
}