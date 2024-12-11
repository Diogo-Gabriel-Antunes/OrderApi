package br.com.api.Repository;

import br.com.api.Model.Order;
import org.acme.SQL.SQLCreator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderRepository extends Repository {


    public List<Order> getAll() {
        try {
            SQLCreator sql = criaSql("Order", "o");
            return sql.listResult(Order.class);
        } catch (NullPointerException e) {
            return null;
        }
    }

    public Long getCountAll() {
        try {
            SQLCreator sql = criaSql("Order", "o");
            return sql.listResult(Order.class).stream().count();
        } catch (NullPointerException e) {
            return 0L;
        }
    }

    public void saveChanges(Order order) {
        em.persist(order);
    }

    public Order getByUuid(String uuid) {
        SQLCreator sql = criaSql("Order", "o")
                .where("o.Uuid = :uuid")
                .param("uuid", uuid);
        return sql.listResult(Order.class).getFirst();
    }
}
