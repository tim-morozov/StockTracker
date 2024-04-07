package com.StockTracker.StockTracker.Models;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Entity
public class StockPortfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long UserPortfolioId;

    private @NotBlank long userId;

    @Column(name="stock_id")
    private @NotBlank long stockId;

    @NotBlank
    private int Amount;

    private Date UpdateDate;

    public long getUserPortfolioId() {
        return UserPortfolioId;
    }

    public void setUserPortfolioId(long userPortfolioId) {
        UserPortfolioId = userPortfolioId;
    }

    public @NotBlank long getUserId() {
        return userId;
    }

    public void setUserId(long UserId) {
        userId = UserId;
    }

    public @NotBlank long getStockId() {
        return stockId;
    }

    @ManyToOne()
    @JoinColumn(name = "stockid")
    private Stock stock;

    public void setStockId(long StockId) {
        stockId = StockId;
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
    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

}
