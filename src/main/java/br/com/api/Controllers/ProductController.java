package br.com.api.Controllers;

import br.com.api.Model.Product;
import br.com.api.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
