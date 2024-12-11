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
    private Set<ProductItem> productItem;
    private String orderUuid;

    public Set<ProductItem> getProduct() {
        return productItem;
    }

    public void setProduct(Set<ProductItem> productItem) {
        this.productItem = productItem;
    }

    public String getOrderUuid() {
        return orderUuid;
    }

    public void setOrderUuid(String orderUuid) {
        this.orderUuid = orderUuid;
    }
}
