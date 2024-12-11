package br.com.api.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Stock extends GenericClass{

    @OneToOne
    private Product product;
    private Double quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
