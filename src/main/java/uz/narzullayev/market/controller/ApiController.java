package uz.narzullayev.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import uz.narzullayev.market.entity.Customer;
import uz.narzullayev.market.service.CustomerService;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/all")
    public List<Customer> allCustomer(){
       return customerService.findAll();
   }

    @GetMapping("/find/{id}")
    public Customer findById(@PathVariable(name = "id") Integer customerId)  {
        return customerService.findByCustomerId(customerId);
    }


}
