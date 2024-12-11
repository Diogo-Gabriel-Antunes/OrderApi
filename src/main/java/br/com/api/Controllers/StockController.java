package br.com.api.Controllers;

import br.com.api.DTO.UpdateStockDTO;
import br.com.api.Model.Stock;
import br.com.api.Services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("stock")
@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public ResponseEntity getAllStocks(){
        List<Stock> stock = stockService.getAll();
        if(stock != null){
            return ResponseEntity.ok(stock);
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("{productUuid}")
    public ResponseEntity updateStock(String productUuid, @RequestBody UpdateStockDTO updateStockDTO){
        Stock stock = stockService.updateStock(productUuid,updateStockDTO);
        return ResponseEntity.ok(stock);
    }
}
