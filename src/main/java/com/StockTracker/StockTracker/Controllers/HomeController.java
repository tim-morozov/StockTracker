package com.StockTracker.StockTracker.Controllers;

import com.StockTracker.StockTracker.Models.Stock;
import com.StockTracker.StockTracker.Models.ViewModels.StockDataViewModel;
import com.StockTracker.StockTracker.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping({"/", "/index"})
public class HomeController {

    @Autowired
    StockService stockService;

    @RequestMapping()
    public ModelAndView Index(){
        ModelAndView mav = new ModelAndView("index");
        var stockList = GetStocks();

        mav.addObject("stocks",stockList);
        return mav;
    }

   @GetMapping("/getStockData")
  @ResponseBody()
   public List<StockDataViewModel> GetStockData(){
        var stockList = stockService.GetAllStocks();

        List<StockDataViewModel> stockDataList = stockList.stream()
               .map(s -> new StockDataViewModel(s.getTicker(),
                       Math.floor(s.getPrice()),
                       round(s.getPrice(), 2),
                       s.getVolume(),
                       round(s.getHigh(), 2),
                       round(s.getLow(), 2))
                       )
               .collect(Collectors.toList());
       return stockDataList;
   }

   private Iterable<Stock> GetStocks(){

        return  stockService.GetAllStocks();
   }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }





}
