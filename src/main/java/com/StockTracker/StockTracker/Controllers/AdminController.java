package com.StockTracker.StockTracker.Controllers;

import com.StockTracker.StockTracker.Models.Holiday;
import com.StockTracker.StockTracker.Models.Market;
import com.StockTracker.StockTracker.Models.MarketSchedule;
import com.StockTracker.StockTracker.Models.Stock;
import com.StockTracker.StockTracker.Models.ViewModels.MarketScheduleViewModel;
import com.StockTracker.StockTracker.Models.ViewModels.MarketViewModel;
import com.StockTracker.StockTracker.Service.HolidayService;
import com.StockTracker.StockTracker.Service.MarketScheduleService;
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
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/administrator")
public class AdminController {

    @Autowired
    private StockService stockService;
    @Autowired
    private MarketService marketService;
    @Autowired
    private MarketScheduleService marketScheduleService;
    @Autowired
    private HolidayService holidayService;

    @RequestMapping()
    public ModelAndView Admin(){
        ModelAndView mav = new ModelAndView("administrator");
        var defaultMarket = marketService.GetMarketTime();
        var defaultMarketSchedule = marketScheduleService.GetMarketSchedule();
        var defaultHoliday = holidayService.GetHoliday();
        Market market = defaultMarket == null ? new Market() : defaultMarket;
        //MarketSchedule marketSchedule = defaultMarketSchedule == null ? new MarketSchedule() : defaultMarketSchedule;
        //Holiday holiday = defaultHoliday == null ? new Holiday() : defaultHoliday;

        MarketViewModel mvm = new MarketViewModel();
        if(market.getMarketId() != 0) {
            mvm.setOpeningTime(market.getOpeningTime().toString());
            mvm.setClosingTime(market.getClosingTime().toString());
        }


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

    @PostMapping("/changemarketschedule")
    public String ChangeMarketSchedule(@RequestParam("days[]") List<String> days,
                                       @RequestParam("holidays[]") List<String> holidays){


        List<MarketSchedule> schedules = days.stream()
                .map(d -> {
                    MarketSchedule schedule = new MarketSchedule();
                    schedule.setDay(d);
                    schedule.setIsOpen((short) 1);
                    return schedule;
                })
                .toList();
        marketScheduleService.SaveMarketSchedule(schedules);

        List<Holiday> holidayList = holidays.stream()
                .map(h ->{
                    Holiday holiday = new Holiday();
                    holiday.setHolidayName(h);
                    holiday.setIsOpen((short) 1);
                    return holiday;
                })
                .toList();
        holidayService.SaveHoliday(holidayList);


        return "redirect:/administrator";
    }

}
