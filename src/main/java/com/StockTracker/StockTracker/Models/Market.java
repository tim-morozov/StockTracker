package com.StockTracker.StockTracker.Models;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long MarketId;
    @NotBlank
    private String Name;
    @NotBlank
    private int Status;
    private Date UpdateDate;

    public long getMarketId() {
        return MarketId;
    }
    public void setMarketId(long marketId) {
        MarketId = marketId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public Date getUpdateDate() {
        return UpdateDate;
    }

    public void setUpdateDate(Date updateDate) {
        UpdateDate = updateDate;
    }
}
