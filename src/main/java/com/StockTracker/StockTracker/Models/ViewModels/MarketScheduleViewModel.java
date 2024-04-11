package com.StockTracker.StockTracker.Models.ViewModels;

import com.StockTracker.StockTracker.Models.Holiday;
import com.StockTracker.StockTracker.Models.MarketSchedule;

import java.util.List;

public class MarketScheduleViewModel {
  private List<MarketSchedule> marketSchedule;
  private List<Holiday> holiday;

    public List<MarketSchedule> getMarketSchedule() {
        return marketSchedule;
    }

    public void setMarketSchedule(List<MarketSchedule> marketSchedule) {
        this.marketSchedule = marketSchedule;
    }

    public List<Holiday> getHoliday() {
        return holiday;
    }

    public void setHoliday(List<Holiday>  holiday) {
        this.holiday = holiday;
    }
}
