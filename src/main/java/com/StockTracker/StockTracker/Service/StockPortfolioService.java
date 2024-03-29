package com.StockTracker.StockTracker.Service;

import com.StockTracker.StockTracker.Models.StockPortfolio;
import com.StockTracker.StockTracker.Repository.StockPortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockPortfolioService {
    @Autowired
    private StockPortfolioRepository stockPortfolioRepository;
    @Autowired
    private StockService stockService;
    @Autowired
    private UserService userService;

    public StockPortfolio GetByStockIdAndUserId(int stockId, int userId){
        return stockPortfolioRepository.findByStockIdAndUserId(stockId, userId);
    }

    public void SellStock(StockPortfolio stockPortfolio, long userId, int amount){
        var stock = stockService.GetById(stockPortfolio.getStockId());
        var amountToAdd = stock.getPrice() * amount;

        if(stockPortfolio.getAmount() < 1){
            stockPortfolioRepository.deleteById(stockPortfolio.getStockId());

        }else{
            stockPortfolioRepository.save(stockPortfolio);
        }

        AddUserBalance(userId, amountToAdd);

    }

    public void BuyStock(StockPortfolio stockPortfolio, long userId, long amount){

        var stock = stockService.GetById(stockPortfolio.getStockId());
        var amountToSubtract = stock.getPrice() * amount;

        stockPortfolioRepository.save(stockPortfolio);
        SubtractUserBalance(userId, amountToSubtract);
    }

    private void AddUserBalance(long userId, double price){
        var user = userService.GetUser(userId);

        user.setBalance(user.getBalance() + price);

        userService.SaveUser(user);
    }

    private void SubtractUserBalance(long userId, double price){
        var user = userService.GetUser(userId);

        user.setBalance(user.getBalance() - price);

        userService.SaveUser(user);
    }
}
