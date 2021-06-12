package uz.narzullayev.market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.narzullayev.market.entity.ProductCategory;
import uz.narzullayev.market.repository.ProductCategoryRepository;

@Service
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;
    @Autowired
    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }


    public ProductCategory save(ProductCategory productCategory){
        return productCategoryRepository.save(productCategory);
    }
}
