package com.StockTracker.StockTracker.Controllers;

import com.StockTracker.StockTracker.Models.StockPortfolio;
import com.StockTracker.StockTracker.Models.User;
import com.StockTracker.StockTracker.Models.ViewModels.TradeViewModel;
import com.StockTracker.StockTracker.Service.StockPortfolioService;
import com.StockTracker.StockTracker.Service.StockService;
import com.StockTracker.StockTracker.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    StockPortfolioService stockPortfolioService;
    @Autowired
    StockService stockService;


    @RequestMapping()
    public ModelAndView User() {
        return new ModelAndView("user");
    }

    @RequestMapping("/managecash")
    public ModelAndView ManageCash(){
        return new ModelAndView("managecash");
    }

    @PostMapping("/processDeposit")
    public ModelAndView ProcessDeposit(@RequestParam("newBalance") Float newBalance, HttpSession session){
        User user = (User)session.getAttribute("user");
        var oldBalance = user.getBalance();
        user.setBalance(oldBalance + newBalance);
        userService.SaveUser(user);

        return new ModelAndView("user");
    }

    @PostMapping("/processWithdraw")
    public ModelAndView ProcessWithdraw(@RequestParam("withdrawBalance") float withdrawBalance, HttpSession session){
        User user = (User)session.getAttribute("user");
        var newBalance = user.getBalance() - withdrawBalance;
        user.setBalance(newBalance);

        userService.SaveUser(user);

        return new ModelAndView("user");
    }



    @RequestMapping("/viewusertradinghistory")
    public ModelAndView ViewUserTradingHistory(){
        return new ModelAndView("viewusertradinghistory");
    }

    @RequestMapping("/makeatrade")
    public ModelAndView MakeATrade(){
        ModelAndView mav = new ModelAndView("makeatrade");
        TradeViewModel trade = new TradeViewModel();
        mav.addObject("trade", trade);
        return mav;
    }

    @PostMapping("user/makeTrade")
    public String MakeTrade(@ModelAttribute("Trade")TradeViewModel trade, HttpSession session){

        var stockId = stockService.GetByTicker(trade.getTicker()).getStockId();
        User user = (User) session.getAttribute("user");

        var currentStock = stockPortfolioService.GetByStockIdAndUserId((int)stockId, (int)user.getId());
        if (currentStock == null && trade.getOption().equals("buy")){
            StockPortfolio stockPortfolio = new StockPortfolio();
            stockPortfolio.setStockId(stockId);
            stockPortfolio.setUserId(user.getId());
            stockPortfolio.setAmount(trade.getAmount());
            stockPortfolio.setUpdateDate(new Date());

            stockPortfolioService.BuyStock(stockPortfolio);
        } else {
            if (trade.getOption().equals("buy")) {
                var newAmount = currentStock.getAmount() + trade.getAmount();
                currentStock.setAmount(newAmount);

                stockPortfolioService.BuyStock(currentStock);
            } else{
                var newAmount = currentStock.getAmount() - trade.getAmount();
                currentStock.setAmount(newAmount);

                stockPortfolioService.SellStock(currentStock);
            }
        }

        return "user";

    }






}
