package com.StockTracker.StockTracker.Service;

import com.StockTracker.StockTracker.Models.MarketSchedule;
import com.StockTracker.StockTracker.Repository.MarketScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketScheduleService {

    @Autowired
    private MarketScheduleRepository marketScheduleRepository;

    public List<MarketSchedule> GetMarketSchedule(){
        return marketScheduleRepository.findAll();
    }

    public MarketSchedule GetByDay(String dayName){
        return marketScheduleRepository.findByDay(dayName);
    }

    public void SaveMarketSchedule(List<MarketSchedule> marketSchedule){
        marketScheduleRepository.deleteAll();
        marketScheduleRepository.saveAll(marketSchedule);
    }
}
