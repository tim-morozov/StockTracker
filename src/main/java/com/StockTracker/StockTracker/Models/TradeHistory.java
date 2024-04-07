package com.StockTracker.StockTracker.Models;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
public class TradeHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tradeHistoryId;
    @NotNull
    private long userId;
    @NotNull
    private String ticker;
    @NotNull
    private long amount;
    @NotNull
    private double price;
    @NotNull
    private String type;
    @NotNull
    private Date transactionDate;

    public long getTradeHistoryId() {
        return tradeHistoryId;
    }

    public void setTradeHistoryId(long tradeHistoryId) {
        this.tradeHistoryId = tradeHistoryId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }


}
