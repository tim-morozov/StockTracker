package com.StockTracker.StockTracker.Models.ViewModels;

public class StockDataViewModel {
    private String ticker;
    private double price;
    private double openingPrice;
    private double volume;
    private double high;
    private double low;

    public StockDataViewModel(String ticker, double price, double openingPrice, double volume, double high, double low) {
        this.ticker = ticker;
        this.price = price;
        this.openingPrice = openingPrice;
        this.volume = volume;
        this.high = high;
        this.low = low;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOpeningPrice() {
        return openingPrice;
    }

    public void setOpeningPrice(double openingPrice) {
        this.openingPrice = openingPrice;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }
}
