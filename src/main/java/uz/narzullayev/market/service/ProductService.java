package uz.narzullayev.market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.narzullayev.market.entity.Product;
import uz.narzullayev.market.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        if (product.getId() == null) {
            return productRepository.save(product);
        }
        throw new RuntimeException("This object exist");
    }

    public Product findProductById(Integer id){
        if (id!=null){
          return  productRepository.findById(id)
                    .orElseThrow(IllegalArgumentException::new);
        }
        throw new NullPointerException("Product id null");
    }

    public Product update(Product product) {
        if (product.getId() != null) {
            return productRepository.save(product);
        }
        throw new RuntimeException("This object not exist");
    }
}
