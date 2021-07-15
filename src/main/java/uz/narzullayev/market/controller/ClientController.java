package uz.narzullayev.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientController {

    @GetMapping("/go")
    public String go(Model model){
        model.addAttribute("message","Hello world");
        return "hello";
    }
}
