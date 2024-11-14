package br.com.api.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
public class Product extends GenericClass {

    private String nome;
    private Double preco;
    @ManyToMany
    private Set<ProductOrder> productOrder;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Set<ProductOrder> getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(Set<ProductOrder> productOrder) {
        this.productOrder = productOrder;
    }
}
