package com.StockTracker.StockTracker.Models;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class StockPortfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long UserPortfolioId;

    @NotBlank
    private int UserId;

    @NotBlank
    private int StockId;

    @NotBlank
    private int Amount;

    private Date UpdateDate;

    public long getUserPortfolioId() {
        return UserPortfolioId;
    }

    public void setUserPortfolioId(long userPortfolioId) {
        UserPortfolioId = userPortfolioId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getStockId() {
        return StockId;
    }

    public void setStockId(int stockId) {
        StockId = stockId;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public Date getUpdateDate() {
        return UpdateDate;
    }

    public void setUpdateDate(Date updateDate) {
        UpdateDate = updateDate;
    }
}
