package br.com.api.Services;


import br.com.api.DTO.ProductOrderDTO;
import br.com.api.Model.Order;
import br.com.api.Model.Product;
import br.com.api.Model.ProductItem;
import br.com.api.Model.ProductOrder;
import br.com.api.Repository.OrderRepository;
import br.com.api.Repository.ProductOrderRepository;
import br.com.api.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class OrderService extends Services{

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductOrderRepository productOrderRepository;

    public List<Order> getOrders() {
        return orderRepository.getAll();
    }

    public Order createOrder(ProductOrderDTO productOrderDTO) {
        Order order = new Order();
        AtomicReference<Double> totalValue = new AtomicReference<>(0D);
        ProductOrder productOrder = getCreateProductOrder(productOrderDTO,totalValue);
        Long lastOrderNumber = orderRepository.getCountAll();
        order.setNumberOrder(lastOrderNumber + 1);
        order.setTotalValue(totalValue.get());
        em.persist(order);
        productOrder.setOrderUuid(order.getUuid());
        em.persist(productOrder);
        order.setProductOrder(productOrder);
        em.persist(order);
        return order;
    }

    private ProductOrder getCreateProductOrder(ProductOrderDTO productOrderDTO, AtomicReference<Double> totalValue) {
        ProductOrder productOrder = new ProductOrder();

        Set<ProductItem> productItemSet = new HashSet<>();

        productOrderDTO.products().stream().forEach(productDTO -> {
            Product product = productRepository.getByUuid(productDTO.uuid());
            if (product != null) {
                ProductItem productItem = new ProductItem();
                productItem.setProduct(product);
                productItem.setQuantity(productDTO.quantity());
                em.persist(productItem);
                productItemSet.add(productItem);
                totalValue.updateAndGet(v -> v + (product.getPreco() * productDTO.quantity()));
            }
        });
        return productOrder;
    }


    public Order updateOrder(String uuid, ProductOrderDTO productOrderDTO) {
        Order order = orderRepository.getByUuid(uuid);
        AtomicReference<Double> totalValue = new AtomicReference<>();
        ProductOrder productOrder = getCreateProductOrder(productOrderDTO, totalValue);
        order.setProductOrder(productOrder);
        order.setTotalValue(totalValue.get());
        em.persist(order);
        return order;
    }

    public void deleteOrder(String uuid) {
        Order order = orderRepository.getByUuid(uuid);
        em.remove(order);
    }
}
