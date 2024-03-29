package com.StockTracker.StockTracker.Service;

import com.StockTracker.StockTracker.Models.StockPortfolio;
import com.StockTracker.StockTracker.Repository.StockPortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockPortfolioService {
    @Autowired
    private StockPortfolioRepository stockPortfolioRepository;

    public StockPortfolio GetByStockIdAndUserId(int stockId, int userId){
        return stockPortfolioRepository.findByStockIdAndUserId(stockId, userId);
    }

    public void SellStock(StockPortfolio stockPortfolio){
        if(stockPortfolio.getAmount() < 1){
            stockPortfolioRepository.deleteById(stockPortfolio.getStockId());

        }else{
            stockPortfolioRepository.save(stockPortfolio);
        }
    }

    public void BuyStock(StockPortfolio stockPortfolio){
        stockPortfolioRepository.save(stockPortfolio);
    }
}
