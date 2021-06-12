package uz.narzullayev.market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.narzullayev.market.repository.OrderDetailsRepository;

@Service
public class OrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository;


    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }
}
