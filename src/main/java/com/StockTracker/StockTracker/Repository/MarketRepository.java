package com.StockTracker.StockTracker.Repository;

import com.StockTracker.StockTracker.Models.Market;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface MarketRepository extends CrudRepository<Market, Serializable> {
}
