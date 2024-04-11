package com.StockTracker.StockTracker.Service;

import com.StockTracker.StockTracker.Models.Holiday;
import com.StockTracker.StockTracker.Repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidayService {

    @Autowired
    private HolidayRepository holidayRepository;

    public List<Holiday> GetHoliday(){
        return holidayRepository.findAll();
    }

    public void SaveHoliday(List<Holiday> holidays){
        holidayRepository.deleteAll();
        holidayRepository.saveAll(holidays);
    }
}
