package com.StockTracker.StockTracker.Repository;

import com.StockTracker.StockTracker.Models.Market;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface MarketRepository extends CrudRepository<Market, Serializable> {

    //@Query("SELECT top 1 m from market m")
    Market findFirst1ByOrderByMarketIdAsc();
}
