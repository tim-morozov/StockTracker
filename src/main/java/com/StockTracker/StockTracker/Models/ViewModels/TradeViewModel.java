package com.StockTracker.StockTracker.Models.ViewModels;

import org.springframework.validation.ObjectError;

import java.util.List;

public class TradeViewModel {

    private String ticker;
    private int amount;

    public List<ObjectError> errorList;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    private String option;
}
