package com.StockTracker.StockTracker.Service;

import com.StockTracker.StockTracker.Models.Stock;
import com.StockTracker.StockTracker.Repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> GetAllStocks(){

        return stockRepository.findAll();
    }

    public Stock GetById(long stockId){
        return stockRepository.findByStockId(stockId);
    }

    public Stock GetByTicker(String ticker){
       return stockRepository.findByTicker(ticker);
    }

    public void SaveStock(Stock stock){

        stockRepository.save(stock);
    }

}
