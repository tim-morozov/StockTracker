package com.StockTracker.StockTracker.Repositories;

import com.StockTracker.StockTracker.Models.Market;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface MarketRepository<Market, Id extends Serializable> extends CrudRepository<Market, Serializable> {

    Market findById(int ID);
    Market save(com.StockTracker.StockTracker.Models.Market market);
}
