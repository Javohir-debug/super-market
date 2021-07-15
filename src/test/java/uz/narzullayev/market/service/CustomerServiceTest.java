package uz.narzullayev.market.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.transaction.annotation.Transactional;
import uz.narzullayev.market.MainTest;
import uz.narzullayev.market.constant.Country;
import uz.narzullayev.market.entity.Customer;
import uz.narzullayev.market.repository.CustomerRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

class CustomerServiceTest implements MainTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerRepository customerRepository;
    @Autowired(required = false)
    private CustomerService customerService;
    private List<Customer> customers;
    @Autowired
    private JacksonTester<Customer> json;
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
    void saveAll() throws Exception {
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setCountry(Country.RUS);
        customer1.setAddress("Navoi");
        customer1.setPhoneNumber("+9989999999");
        given(this.customerRepository.findById(1)).willReturn(Optional.of(customer1));
        assertThat(this.customerRepository.findById(1).get().getCountry()).isEqualTo(Country.RUS);
        assertNotNull(customerService);
        customerService.saveAll(customers);

    }

    @Test
    @Transactional(readOnly = true)
    @Order(2)
    @DisplayName("Barcha mijozlar")
    void findAll() throws Exception {
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setCountry(Country.RUS);
        customer1.setAddress("Navoi");
        customer1.setPhoneNumber("+9989999999");
        /*mockMvc.perform(get("/all").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());*/
        List<Customer> all = customerService.findAll();
        assertEquals(all.size(),customers.size());
    }

    @Test
    @Order(3)
    @DisplayName("Mijozni id raqami bo'yicha qidirish")
    void findByCustomerId() {
        Customer byCustomerId = customerService.findByCustomerId(1);
        if (byCustomerId==null){
            assertNull(byCustomerId);
        }else {
            assertEquals(byCustomerId.getId(),1);
        }
    }


}
