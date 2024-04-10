package com.StockTracker.StockTracker.Controllers;

import com.StockTracker.StockTracker.Models.Market;
import com.StockTracker.StockTracker.Models.Stock;
import com.StockTracker.StockTracker.Models.ViewModels.MarketViewModel;
import com.StockTracker.StockTracker.Service.MarketService;
import com.StockTracker.StockTracker.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

@Controller
@RequestMapping("/administrator")
public class AdminController {

    @Autowired
    private StockService stockService;

    @Autowired
    private MarketService marketService;

    @RequestMapping()
    public ModelAndView Admin(){
        ModelAndView mav = new ModelAndView("administrator");
        var defaultMarket = marketService.GetMarketTime();
        Market market = defaultMarket == null ? new Market() : defaultMarket;

        MarketViewModel mvm = new MarketViewModel();
        mvm.setOpeningTime(market.getOpeningTime().toString());
        mvm.setClosingTime(market.getClosingTime().toString());

        Stock stock = new Stock();
        mav.addObject("stock", stock);
        mav.addObject("market", mvm);

        return mav;
    }

    @PostMapping("/createstock")
    public String CreateStock(@ModelAttribute("stock") Stock stock, BindingResult result){

        stock.setUpdateDate(new Date());
        stock.setHigh(stock.getPrice());
        stock.setLow(stock.getPrice());

        stockService.SaveStock(stock);

        return "redirect:/administrator";
    }

    @PostMapping("/changemarkethours")
    public String ChangeMarketHours(@ModelAttribute("market") MarketViewModel market){

        LocalTime newOpen = LocalTime.parse(market.getOpeningTime());
        LocalTime newClose = LocalTime.parse(market.getClosingTime());
        Market defaultMarket = marketService.GetMarketTime();

       if(defaultMarket != null){
           defaultMarket.setOpeningTime(newOpen);
           defaultMarket.setClosingTime(newClose);

           marketService.SaveMarket(defaultMarket);
       }else{
           Market newMarket = new Market();
           newMarket.setOpeningTime(newOpen);
           newMarket.setClosingTime(newClose);
           marketService.SaveMarket(newMarket);
       }

        return "redirect:/administrator";
    }

}
