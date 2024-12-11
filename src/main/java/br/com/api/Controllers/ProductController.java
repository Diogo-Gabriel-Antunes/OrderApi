package br.com.api.Controllers;

import br.com.api.DTO.ProductDTO;
import br.com.api.Model.Product;
import br.com.api.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("product")
@RestController
public class ProductController {


    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity getAll(){
        List<Product> products = productService.getAll();
        if(products != null){
            return ResponseEntity.ok(products);
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ProductDTO productDTO){
        Product product = productService.create(productDTO);
        return ResponseEntity.created(URI.create(product.getUuid())).build();
    }

    @PutMapping("{uuid}")
    public ResponseEntity update(String uuid,@RequestBody ProductDTO productDTO){
        Product product = productService.update(uuid,productDTO);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("{uuid}")
    public ResponseEntity delete(String uuid){
        productService.delete(uuid);
        return ResponseEntity.ok("Produto selecionado deletado com sucesso");
    }
}
