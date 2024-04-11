package com.StockTracker.StockTracker.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.validation.constraints.NotNull;

@Entity
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long holidayId;
    @NotNull
    private String holidayName;
    @NotNull
    private short isOpen;
    

    public long getHolidayId() {
        return holidayId;
    }

    public void setHolidayId(long holidayId) {
        this.holidayId = holidayId;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }

    public short getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(short isOpen) {
        this.isOpen = isOpen;
    }
}
