package com.StockTracker.StockTracker.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.validation.constraints.NotBlank;
import java.sql.Time;
import java.util.Date;

@Entity
public class MarketSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long MarketScheduleId;
    @NotBlank
    private Time MarketOpen;
    @NotBlank
    private Time MarketClose;
    @NotBlank
    private Date ScheduleStart;
    @NotBlank
    private Date ScheduleEnd;

    public long getMarketScheduleId() {
        return MarketScheduleId;
    }

    public void setMarketScheduleId(long marketScheduleId) {
        MarketScheduleId = marketScheduleId;
    }

    public Time getMarketOpen() {
        return MarketOpen;
    }

    public void setMarketOpen(Time marketOpen) {
        MarketOpen = marketOpen;
    }

    public Time getMarketClose() {
        return MarketClose;
    }

    public void setMarketClose(Time marketClose) {
        MarketClose = marketClose;
    }

    public Date getScheduleStart() {
        return ScheduleStart;
    }

    public void setScheduleStart(Date scheduleStart) {
        ScheduleStart = scheduleStart;
    }

    public Date getScheduleEnd() {
        return ScheduleEnd;
    }

    public void setScheduleEnd(Date scheduleEnd) {
        ScheduleEnd = scheduleEnd;
    }
}
