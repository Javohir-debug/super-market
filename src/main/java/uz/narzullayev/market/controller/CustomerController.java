package uz.narzullayev.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uz.narzullayev.market.entity.Customer;
import uz.narzullayev.market.service.CustomerService;

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

    @GetMapping(path = "/all")
    public String allCustomer(Model model){
        model.addAttribute("customers",customerService.findAll());
        model.addAttribute("msg","Hello user");
        return "user/list-customer";
    }

    @GetMapping(path = "/edit/{id}")
    public String editCustomer(@PathVariable("id")Integer customerId, Model model){
        Customer customerById = customerService.findByCustomerId(customerId);
        model.addAttribute("editCustomer",customerById);
        return "user/add-edit-customer";
    }
    @PostMapping(path = "/update")
    public String postEditCustomer(@ModelAttribute("editCustomer") Customer customer){
        customerService.save(customer);
        return "redirect:/customer/all";
    }

    @RequestMapping(path = "/delete/{customerId}")
    public String postEditCustomer(
              @PathVariable(value = "customerId",required = false)Integer customerId
            , RedirectAttributes redirectAttributes){
        if (customerId==null){
            redirectAttributes.addAttribute("msg","Id is null!!");
            return "redirect:/customer/all";
        }
        customerService.deleteCustomerById(customerId);
        redirectAttributes.addAttribute("msg","successfully removed entity by id");
        return "redirect:/customer/all";
    }



}
