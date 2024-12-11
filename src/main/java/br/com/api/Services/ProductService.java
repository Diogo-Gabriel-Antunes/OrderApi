package br.com.api.Services;

import br.com.api.DTO.ProductDTO;
import br.com.api.Model.Product;
import br.com.api.Model.Stock;
import br.com.api.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }
    @Transactional
    public Product create(ProductDTO productDTO) {
        Product product = convertDTO(productDTO);
        productRepository.saveChanges(product);
        Stock stock = new Stock();
        stock.setProduct(product);
        stock.setQuantity(0D);
        return product;
    }

    private Product convertDTO(ProductDTO productDTO) {
        Product product = new Product();
        convertDTO(product,productDTO);
        return product;
    }
    private void convertDTO(Product product,ProductDTO productDTO) {
        product.setNome(productDTO.nome());
        product.setPreco(productDTO.preco());
    }
    @Transactional
    public Product update(String uuid, ProductDTO productDTO) {
        Product product = productRepository.getByUuid(uuid);
        convertDTO(product, productDTO);
        productRepository.saveChanges(product);
        return product;
    }

    @Transactional
    public void delete(String uuid) {
        Product product = productRepository.getByUuid(uuid);
        productRepository.delete(product);
    }
}
