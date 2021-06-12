package uz.narzullayev.market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;
import uz.narzullayev.market.entity.Product;
import uz.narzullayev.market.repository.ProductRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(Product product){
       return productRepository.save(product);
    }

    public Product findById(Integer productId){
        return productRepository.findById(productId).orElse(null);
    }

    public Product finByIdWithPhoto(Integer productId){
       return productRepository.getProductById(productId);
    }
}
