package com.StockTracker.StockTracker.Services;

import com.StockTracker.StockTracker.Models.StockPortfolio;
import com.StockTracker.StockTracker.Repositories.StockPortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StockPortfolioService {

    @Autowired
    private StockPortfolioRepository stockPortfolioRepository;

    public List<StockPortfolio> FindByUserId(int UserID){
        var userPortfolio = stockPortfolioRepository.FindByUserId(UserID);

        return userPortfolio;
    }

}
