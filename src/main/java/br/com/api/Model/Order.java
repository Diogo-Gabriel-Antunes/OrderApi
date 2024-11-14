package br.com.api.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends GenericClass{
    private Long numberOrder;
    private Double totalValue;
    @OneToMany(mappedBy = "order")
    private List<ProductOrder> productOrder;
    public List<ProductOrder> getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(List<ProductOrder> productOrder) {
        this.productOrder = productOrder;
    }

}
