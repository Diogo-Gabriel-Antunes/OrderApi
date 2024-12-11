package br.com.api.Repository;

import br.com.api.Model.Stock;
import org.acme.SQL.SQLCreator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockRepository extends Repository{

    public List<Stock> getAll() {
        try {
            SQLCreator sql = criaSql("Stock", "s");
            return sql.listResult(Stock.class);
        }catch (NullPointerException e){
            return null;
        }
    }

    public Stock getByProductUuid(String productUuid) {
        try{
            return criaSql("Stock","s")
                    .from("LEFT JOIN s.product p")
                    .where("p.uuid = :productUuid")
                    .param("productUuid",productUuid)
                    .listResult(Stock.class)
                    .getFirst();
        }catch (NullPointerException e){
            throw new RuntimeException("Produto não encontrado");
        }
    }
}
