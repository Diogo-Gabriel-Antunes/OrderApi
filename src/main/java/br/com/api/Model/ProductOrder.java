package br.com.api.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
public class ProductOrder extends GenericClass{

    @ManyToMany
    @JoinTable(
            name = "product_order_item", // nome da tabela intermediária
            joinColumns = @JoinColumn(name = "product_uuid"), // chave estrangeira para a entidade Aluno
            inverseJoinColumns = @JoinColumn(name = "order_uuid") // chave estrangeira para a entidade Curso
    )
    private Set<Product> product;
    @ManyToOne
    private Order order;

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
