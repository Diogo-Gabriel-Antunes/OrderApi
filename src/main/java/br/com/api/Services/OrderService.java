package br.com.api.Services;


import br.com.api.DTO.CreateOrderDTO;
import br.com.api.Model.Order;
import br.com.api.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrders() {
        return orderRepository.getAll();
    }

    public Order createOrder(CreateOrderDTO createOrderDTO) {
//        Order order = generateOrder(createOrderDTO);
        return null;
    }

//    private Order generateOrder(CreateOrderDTO createOrderDTO) {
//        Order order = new Order();
//        createOrderDTO.productOrderDTO().stream().forEach(p->{
//
//        });
//
//    }
}
