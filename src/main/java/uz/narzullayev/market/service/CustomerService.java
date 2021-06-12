package uz.narzullayev.market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.narzullayev.market.entity.Customer;
import uz.narzullayev.market.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public void saveAll(List<Customer> customerList) {
       customerRepository.saveAll(customerList);

    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findByCustomerId(Integer customerId) {
        if (customerId!=null){
            return  customerRepository
                   .findById(customerId)
                   .orElseThrow(() -> new IllegalArgumentException("could not found customer by id"));
        }
        return null;

    }

}
