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

    private final CustomerService customerService;
    @Autowired
    public ApiController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/all")
    public List<Customer> allCustomer(){
        System.out.println("sout");
        return customerService.findAll();
   }

    @GetMapping("/find/{id}")
    public Customer findById(@PathVariable(name = "id") Integer customerId)  {
        return customerService.findByCustomerId(customerId);
    }


}
