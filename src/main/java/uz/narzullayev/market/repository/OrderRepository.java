package uz.narzullayev.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.narzullayev.market.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {
}
