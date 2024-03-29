package com.StockTracker.StockTracker.Controllers;

import com.StockTracker.StockTracker.Models.Stock;
import com.StockTracker.StockTracker.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

   private Iterable<Stock> GetStocks(){

        return  stockService.GetAllStocks();
   }



}
