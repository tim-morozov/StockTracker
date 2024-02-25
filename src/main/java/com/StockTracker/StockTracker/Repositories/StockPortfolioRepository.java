package com.StockTracker.StockTracker.Repositories;

import com.StockTracker.StockTracker.Models.StockPortfolio;
import org.springframework.data.repository.CrudRepository;
import java.io.Serializable;
import java.util.List;

public interface StockPortfolioRepository<StockMarket, Id extends Serializable> extends CrudRepository<StockPortfolio, Serializable> {

    List<StockPortfolio> FindByUserId(int UserId);

}
