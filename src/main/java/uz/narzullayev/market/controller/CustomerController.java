package uz.narzullayev.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.narzullayev.market.entity.Customer;
import uz.narzullayev.market.service.CustomerService;

import java.util.List;

/**
 * Created by Javohir Narzullayev on 7/15/2021.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping(path = "/list")
    public String customerList(Model modelAttribute){
        List<Customer> customers = customerService.findAll();
        customers=customers.size()==0?null:customers;
        modelAttribute.addAttribute("customers",customers);
        return "user/list-customer";
    }

    @GetMapping(path = "/edit/{id}")
    public String customerEdit(@PathVariable(name = "id")Integer customerId, Model modelAttribute){
        Customer customer = customerService.findByCustomerId(customerId);
        modelAttribute.addAttribute("editCustomer",customer);
        return "user/add-edit-customer";
    }

    @PostMapping(path = "/update")
    public String customerEdit(@ModelAttribute(name = "editCustomer") Customer customer){
        customerService.save(customer);
        return "redirect:/customer/list";
    }


    @GetMapping(path = "/delete/{id}")
    public String customerDelete(@PathVariable(name = "id") Integer customerId){
        customerService.deleteCustomerById(customerId);
        return "redirect:/customer/list";
    }

    @PostMapping(path = "/search")
    public String customerDelete(@RequestParam("customerAddress") String customerAddress,Model modelAttribute){
        List<Customer> customers = customerService.findByCustomerAddress(customerAddress);
        customers=customers.size()==0?null:customers;
        modelAttribute.addAttribute("customers",customers);
        return "user/list-customer";
    }



}
