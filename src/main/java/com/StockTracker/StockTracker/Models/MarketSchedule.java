package com.StockTracker.StockTracker.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.validation.constraints.NotNull;

@Entity
public class MarketSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long MarketScheduleId;
    @NotNull
    private String day;
    @NotNull
    private short isOpen;


    public long getMarketScheduleId() {
        return MarketScheduleId;
    }

    public void setMarketScheduleId(long marketScheduleId) {
        MarketScheduleId = marketScheduleId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public short getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(short isOpen) {
        this.isOpen = isOpen;
    }
}
