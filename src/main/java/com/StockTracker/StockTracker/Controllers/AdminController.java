package com.StockTracker.StockTracker.Controllers;

import com.StockTracker.StockTracker.Models.Stock;
import com.StockTracker.StockTracker.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/administrator")
public class AdminController {

    @Autowired
    private StockService stockService;

    @RequestMapping()
    public ModelAndView Admin(){
        ModelAndView mav = new ModelAndView("administrator");
        Stock stock = new Stock();
        mav.addObject("stock", stock);

        return mav;
    }

    @PostMapping("/createstock")
    public String CreateStock(@ModelAttribute("stock") Stock stock, BindingResult result){

        stock.setUpdateDate(new Date());

        stockService.SaveStock(stock);

        return "redirect:/administrator";
    }

}
