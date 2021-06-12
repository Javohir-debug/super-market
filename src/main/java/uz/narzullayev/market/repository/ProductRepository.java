package uz.narzullayev.market.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.narzullayev.market.entity.Product;



@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @EntityGraph(value = Product.PHOTOS,type = EntityGraph.EntityGraphType.LOAD)
    Product getProductById(Integer productId);

}
