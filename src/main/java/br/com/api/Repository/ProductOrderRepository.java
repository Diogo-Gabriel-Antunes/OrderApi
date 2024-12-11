package br.com.api.Repository;

import br.com.api.Model.Order;
import br.com.api.Model.ProductOrder;
import org.acme.SQL.SQLCreator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOrderRepository extends Repository {

    public void createProductOrder(ProductOrder productOrder){
        em.persist(productOrder);
    }
}
