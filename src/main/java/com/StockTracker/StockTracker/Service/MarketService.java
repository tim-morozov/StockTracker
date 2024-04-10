package com.StockTracker.StockTracker.Service;

import com.StockTracker.StockTracker.Models.Market;
import com.StockTracker.StockTracker.Repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketService {

    @Autowired
    private MarketRepository marketRepository;

    public Market GetMarketTime(){
        return marketRepository.findFirst1ByOrderByMarketIdAsc();
    }

    public void SaveMarket(Market market){
        marketRepository.save(market);
    }
}
