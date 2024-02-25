package com.StockTracker.StockTracker.Services;
import com.StockTracker.StockTracker.Models.Stock;
import com.StockTracker.StockTracker.Repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService  {

    @Autowired
    private StockRepository stockRepository;


    public Stock getStockById(int Id){
        var stock = stockRepository.GetStockById(Id);

        return (Stock) stock;
    }

    public Iterable<Stock> getAllStocks(){
        var stockList = stockRepository.findAll();

        return stockList;
    }

    public void SaveStock(Stock stock){

         stockRepository.save(stock);
    }
}
