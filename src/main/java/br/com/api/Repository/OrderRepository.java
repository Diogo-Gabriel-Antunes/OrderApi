package br.com.api.Repository;

import br.com.api.Model.Order;
import org.acme.SQL.SQLCreator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderRepository extends Repository {


    public List<Order> getAll() {
        try{
            SQLCreator sql = criaSql("Order", "o");
            return sql.listResult(Order.class);
        } catch (NullPointerException e) {
            return null;
        }
    }
}
