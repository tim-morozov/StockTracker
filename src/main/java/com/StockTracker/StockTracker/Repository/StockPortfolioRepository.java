package com.StockTracker.StockTracker.Repository;

import com.StockTracker.StockTracker.Models.StockPortfolio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface StockPortfolioRepository extends CrudRepository<StockPortfolio, Serializable> {

    StockPortfolio findByStockIdAndUserId(int StockId, int UserId);
}
