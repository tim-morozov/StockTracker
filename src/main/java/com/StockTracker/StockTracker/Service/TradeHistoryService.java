package com.StockTracker.StockTracker.Service;

import com.StockTracker.StockTracker.Models.TradeHistory;
import com.StockTracker.StockTracker.Repository.TradeHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeHistoryService {

    @Autowired
    TradeHistoryRepository tradeHistoryRepository;

    public List<TradeHistory> GetTradeHistoryByUser(long userId){
        return tradeHistoryRepository.findByUserIdOrderByTransactionDateAsc(userId);
    }

    public void SaveTransaction(TradeHistory tradeHistory){
        tradeHistoryRepository.save(tradeHistory);
    }
}
