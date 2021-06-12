package uz.narzullayev.market.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import uz.narzullayev.market.MainTest;
import uz.narzullayev.market.SuperMarketApplicationTests;
import uz.narzullayev.market.constant.Country;
import uz.narzullayev.market.entity.Customer;
import uz.narzullayev.market.repository.CustomerRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class CustomerServiceTest implements MainTest {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;
    private List<Customer> customers;

    @BeforeAll
    public void setup() throws Exception{
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setCountry(Country.RUS);
        customer1.setAddress("Navoi");
        customer1.setPhoneNumber("+9989999999");

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setCountry(Country.UZB);
        customer2.setAddress("Toshkent");
        customer2.setPhoneNumber("+99888888888");

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setCountry(Country.RUS);
        customer3.setAddress("Namangan");
        customer3.setPhoneNumber("+99877777777");

        Customer customer4 = new Customer();
        customer4.setId(4);
        customer4.setCountry(Country.UZB);
        customer4.setAddress("Buxoro");
        customer4.setPhoneNumber("+99896666666");

        customers=Arrays.asList(
                customer1,
                customer2,
                customer3,
                customer4
        );
    }


    @Test
    @DisplayName("Mijozlar qo'shish")
    @Order(1)
    void saveAll() {
        assertNotNull(customerService);
        customerService.saveAll(customers);

    }

    @Test
    @Transactional(readOnly = true)
    @Order(2)
    @DisplayName("Barcha mijozlar")
    void findAll() {
        List<Customer> all = customerService.findAll();
        assertEquals(all.size(),customers.size());
    }

    @Test
    @Order(3)
    @DisplayName("Mijozni id raqami bo'yicha qidirish")
    void findByCustomerId() {
        Customer byCustomerId = customerService.findByCustomerId(1);
        if (byCustomerId==null){
            assertThrows(IllegalArgumentException.class,()-> System.out.println("Not found customer by this id"));
        }else {
            assertEquals(byCustomerId.getId(),1);
        }
    }


}
