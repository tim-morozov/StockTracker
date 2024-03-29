package com.StockTracker.StockTracker.Repository;

import com.StockTracker.StockTracker.Models.TradeHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface TradeHistoryRepository extends CrudRepository<TradeHistory, Serializable> {
    List<TradeHistory> findByUserIdOrderByTransactionDateAsc(long userId);
}
