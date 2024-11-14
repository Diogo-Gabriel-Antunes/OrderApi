package br.com.api.Repository;

import br.com.api.Model.Product;
import org.acme.SQL.SQLCreator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductRepository extends Repository{


    public Product getByUuid(String uuid){
        try{
            SQLCreator sql = criaSql("Product", "p");
            return sql.listResult(Product.class).get(1);
        }catch (NullPointerException e){
            throw new RuntimeException(e);
        }
    }

    public List<Product> getAll() {
        try{
            SQLCreator sql = criaSql("Product", "p");
            return sql.listResult(Product.class);
        }catch (NullPointerException e){
            throw new RuntimeException(e);
        }
    }
}
