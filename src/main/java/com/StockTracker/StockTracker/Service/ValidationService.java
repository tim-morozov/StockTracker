package com.StockTracker.StockTracker.Service;

import com.StockTracker.StockTracker.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Ref;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ValidationService {

    @Autowired
    private MarketScheduleService marketScheduleService;
    @Autowired
    private MarketService marketService;
    @Autowired
    private StockService stockService;

    public List<String> ValidateTransaction(User user,
                                            int amount,
                                            double price,
                                            String option,
                                            String ticker){
        List<String> errorList = new ArrayList<>();
        var transactionAmount = amount * price;
        if(option.equalsIgnoreCase("buy")&&(user.getBalance() < transactionAmount)){
            errorList.add("Insufficient balance. Please deposit more money into your account");
        }

        var today = new Date();
        Format f = new SimpleDateFormat("EEEE");
        var dayName = f.format(today);
        var validDay = marketScheduleService.GetByDay(dayName) != null;
        if(!validDay){
            errorList.add("Market is not open today.");
        }

        var time = LocalTime.now();
        var marketTime = marketService.GetMarketTime();
        var validTime = marketTime != null ? (time.isAfter(marketTime.getOpeningTime()) && time.isBefore(marketTime.getClosingTime())) : true;
        if(!validTime){
            errorList.add("Market is currently closed.");
        }

        var stock = stockService.GetByTicker(ticker);
        var validStock = stock != null;
        if(!validStock){
            errorList.add(String.format("Stock %1$s is not available to trade ", ticker));
        }

        return errorList;
    }
}
