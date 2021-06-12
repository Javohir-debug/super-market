package uz.narzullayev.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.narzullayev.market.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {


}
