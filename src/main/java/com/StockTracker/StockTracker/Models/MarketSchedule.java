package com.StockTracker.StockTracker.Models;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;

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
