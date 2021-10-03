package uz.narzullayev.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import uz.narzullayev.market.constant.Country;
import uz.narzullayev.market.entity.Customer;
import uz.narzullayev.market.service.CustomerService;

import java.util.Collections;

@SpringBootApplication
public class SuperMarketApplication {

    private final CustomerService customerService;
    @Autowired
    public SuperMarketApplication(CustomerService customerService) {
        this.customerService = customerService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SuperMarketApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            Customer customer1=new Customer();
            customer1.setId(1);
            customer1.setAddress("SUXROB");
            customer1.setCountry(Country.RUS);
            customer1.setPhoneNumber("+9999999");


            customerService.saveAll(Collections.singletonList(customer1));

        };
    }
}
