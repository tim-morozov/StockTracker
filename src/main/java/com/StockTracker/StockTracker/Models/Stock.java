package com.StockTracker.StockTracker.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Stock extends Object {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long StockId;


    @NotBlank
    private String CompanyName;

    @NotBlank
    private String ticker;

    @NotBlank
    private double Price;

    @NotBlank
    private double Volume;

    private Date UpdateDate;

    public long getStockId() {

        return StockId;
    }

    public void setStockId(long stockId) {

        StockId = stockId;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }


    public String getTicker() {

        return ticker;
    }

    public void setTicker(String ticker) {

        ticker = ticker;
    }

    public double getPrice() {

        return Price;
    }

    public void setPrice(double price) {

        Price = price;
    }

    public double getVolume() {

        return Volume;
    }

    public void setVolume(double volume) {

        Volume = volume;
    }

    public Date getUpdateDate() {

        return UpdateDate;
    }

    public void setUpdateDate(Date updateDate) {

        UpdateDate = updateDate;
    }
}
