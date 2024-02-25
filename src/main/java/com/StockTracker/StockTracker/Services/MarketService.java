package com.StockTracker.StockTracker.Services;

import com.StockTracker.StockTracker.Models.Market;
import com.StockTracker.StockTracker.Repositories.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MarketService {

    @Autowired
    private MarketRepository marketRepository;

    public Object GetMarketById(int id){
        var market = marketRepository.findById(id);

        return market;
    }

    public void SaveMarket(Market market){
        var res = marketRepository.save(market);
    }
}
