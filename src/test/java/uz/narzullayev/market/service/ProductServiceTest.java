package uz.narzullayev.market.service;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import uz.narzullayev.market.MainTest;
import uz.narzullayev.market.entity.Photo;
import uz.narzullayev.market.entity.Product;
import uz.narzullayev.market.entity.ProductCategory;
import uz.narzullayev.market.repository.PhotoRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest implements MainTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private PhotoRepository photoRepository;
    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private LoadService loadService;
    private Product product;

    @BeforeAll
    public void init() throws Exception{
        ProductCategory productCategory=new ProductCategory();
        productCategory.setId(1);
        productCategory.setCategoryName("Elektronika");
        ProductCategory category = productCategoryService.save(productCategory);

        Product product=new Product();
        product.setId(1);
        product.setCategory(category);
        product.setPrice(9_000_000.0);
        product.setProductName("Hp");
        product.setDescription("Arzon va sifatli");

        Photo array = new Photo(1, "Birinchi", 900, "c", "jpg", product);
        Photo photo = new Photo(2, "Ikkinchi", 600, "c", "pmg", product);
        Photo photo1 = new Photo(3, "Uchinchi", 404, "c", "bnp", product);
        Set<Photo> photoList= Stream.of(array,photo,photo1).collect(Collectors.toSet());
        product.setPhotos(photoList);

        this.product=product;


    }
    @Test
    @Order(2)
    @Transactional(readOnly = true)
    void findAllProduct() {
        assertNotNull(productCategoryService);
        assertNotNull(productService);
        List<Product> allProduct = productService.findAllProduct();
        System.out.println();

    }

    @Test
    @Order(1)
    void save() {
        Product product = this.product;
        Set<Photo> photos = product.getPhotos();
        product.setPhotos(new HashSet<>());
        product.setCategoryId(product.getCategory().getId());
        Product save = productService.update(product);
        assertEquals(product.getId(),save.getId());
        save.setPhotos(photos);
        productService.update(save);
    }

    @Test
    @Order(3)
    @DisplayName("Lazy and eager")
    void test_lazy_and_eager() {
        Product productById = productService.findProductById(1);
        Product product =
                loadService.lazy_to_eager(Product.class, Product.PHOTOS, 1);
        product.getPhotos().forEach(photo -> {
            photo.getProduct().getPhotos().forEach(photo1 -> {

            });
        });
        System.out.println("\n");
    }
}