package com.StockTracker.StockTracker.Controllers;

import com.StockTracker.StockTracker.Models.Stock;
import com.StockTracker.StockTracker.Services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.time.Instant;
import java.util.Date;


@Controller
@RequestMapping("Stock")
public class StockController {
    @Autowired
    private StockService stockService;


    @GetMapping("GetAllStocks")
    public Iterable<Stock> GetAllStocks(){
        return stockService.getAllStocks();
    }
    @GetMapping("GetStock/{id}")
    public Stock GetStockById(@PathVariable int Id){
        return stockService.getStockById(Id);
    }

    @PostMapping("NewStock")
    public void SaveStock(@RequestBody Stock stock){
       Stock newStock = new Stock();

       newStock.setTicker(stock.getTicker());
       newStock.setPrice(stock.getPrice());
       newStock.setVolume(stock.getVolume());
       newStock.setUpdateDate(Date.from(Instant.now()));

       stockService.SaveStock(newStock);
    }



}
