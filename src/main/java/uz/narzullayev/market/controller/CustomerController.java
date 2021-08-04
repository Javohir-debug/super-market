package uz.narzullayev.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Javohir Narzullayev on 7/15/2021.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {


    @GetMapping(path = "/list")
    public String customerList(){
        return "user-profile-lite";
    }

}
