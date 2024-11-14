package br.com.api.Controllers;


import br.com.api.DTO.CreateOrderDTO;
import br.com.api.Model.Order;
import br.com.api.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("order")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity getOrders(){
        List<Order> orders = orderService.getOrders();
        if(orders != null){
            return ResponseEntity.ok(orders);
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity createOrder(@RequestBody CreateOrderDTO createOrderDTO){
        Order order = orderService.createOrder(createOrderDTO);
        return ResponseEntity.created(URI.create(order.getUuid())).build();
    }
}
