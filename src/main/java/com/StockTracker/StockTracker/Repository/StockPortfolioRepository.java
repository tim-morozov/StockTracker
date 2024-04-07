package com.StockTracker.StockTracker.Repository;

import com.StockTracker.StockTracker.Models.StockPortfolio;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface StockPortfolioRepository extends CrudRepository<StockPortfolio, Serializable> {

    StockPortfolio findByStockIdAndUserId(int StockId, int UserId);

    //@Query("select s,st from stockportfolio s inner join stock st on s.stockId = st.stockId where s.userId = :userId")
    List<StockPortfolio> findByUserId( long userId);
}
