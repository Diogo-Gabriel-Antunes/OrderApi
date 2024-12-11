package br.com.api.Services;

import br.com.api.DTO.UpdateStockDTO;
import br.com.api.Model.Stock;
import br.com.api.Repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService extends Services{

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getAll() {
        List<Stock> stockList =  stockRepository.getAll();
        return stockList;
    }

    public Stock updateStock(String productUuid, UpdateStockDTO updateStockDTO) {
        Stock stock = stockRepository.getByProductUuid(productUuid);
        stock.setQuantity(updateStockDTO.quantity());
        em.persist(stock);
        return stock;
    }
}
