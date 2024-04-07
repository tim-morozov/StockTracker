package com.StockTracker.StockTracker.Controllers;

import com.StockTracker.StockTracker.Models.Stock;
import com.StockTracker.StockTracker.Models.StockPortfolio;
import com.StockTracker.StockTracker.Models.TradeHistory;
import com.StockTracker.StockTracker.Models.User;
import com.StockTracker.StockTracker.Models.ViewModels.StockPortfolioViewModel;
import com.StockTracker.StockTracker.Models.ViewModels.TradeViewModel;
import com.StockTracker.StockTracker.Service.StockPortfolioService;
import com.StockTracker.StockTracker.Service.StockService;
import com.StockTracker.StockTracker.Service.TradeHistoryService;
import com.StockTracker.StockTracker.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    StockPortfolioService stockPortfolioService;
    @Autowired
    StockService stockService;
    @Autowired
    TradeHistoryService tradeHistoryService;


    @RequestMapping()
    public ModelAndView User(HttpSession session) {
        User user = (User)session.getAttribute("user");

        List<StockPortfolio> portfolio = stockPortfolioService.GetUserPortfolio(user.getId());

        portfolio.forEach(p -> p.setStock(stockService.GetById(p.getStockId())));

        var portfolioList = portfolio.stream()
                .map( p -> new StockPortfolioViewModel(p.getStock().getTicker(), p.getAmount(), p.getStock().getPrice()))
                .collect(Collectors.toList());
        ModelAndView mav = new ModelAndView("user");
        mav.addObject("portfolio", portfolioList);
        return mav;
    }

    @RequestMapping("/managecash")
    public ModelAndView ManageCash(){
        return new ModelAndView("managecash");
    }

    @PostMapping("/processDeposit")
    public ModelAndView ProcessDeposit(@RequestParam("newBalance") Float newBalance, HttpSession session){
        User user = (User)session.getAttribute("user");
        @NotBlank double oldBalance = user.getBalance();
        user.setBalance(oldBalance + newBalance);
        userService.SaveUser(user);

        return new ModelAndView("user");
    }

    @PostMapping("/processWithdraw")
    public ModelAndView ProcessWithdraw(@RequestParam("withdrawBalance") float withdrawBalance, HttpSession session){
        User user = (User)session.getAttribute("user");
        double newBalance = user.getBalance() - withdrawBalance;
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


        User user = (User) session.getAttribute("user");
        TradeHistory tradeHistory = new TradeHistory();
        tradeHistory.setUserId(user.getId());
        tradeHistory.setTicker(trade.getTicker());
        tradeHistory.setAmount(trade.getAmount());
        tradeHistory.setType(trade.getOption());
        tradeHistory.setTransactionDate(new Date());

        var stockId = stockService.GetByTicker(trade.getTicker()).getStockId();

        var currentStock = stockPortfolioService.GetByStockIdAndUserId((int)stockId, (int)user.getId());
        if (currentStock == null && trade.getOption().equals("buy")){
            StockPortfolio stockPortfolio = new StockPortfolio();
            stockPortfolio.setStockId(stockId);
            stockPortfolio.setUserId(user.getId());
            stockPortfolio.setAmount(trade.getAmount());
            stockPortfolio.setUpdateDate(new Date());

            stockPortfolioService.BuyStock(stockPortfolio, user.getId(), trade.getAmount());
            tradeHistoryService.SaveTransaction(tradeHistory);
        } else {
            if (trade.getOption().equals("buy")) {
                var newAmount = currentStock.getAmount() + trade.getAmount();
                currentStock.setAmount(newAmount);

                stockPortfolioService.BuyStock(currentStock,user.getId(), trade.getAmount());
                tradeHistoryService.SaveTransaction(tradeHistory);
            } else{
                var newAmount = currentStock.getAmount() - trade.getAmount();
                currentStock.setAmount(newAmount);

                stockPortfolioService.SellStock(currentStock, user.getId(), trade.getAmount());
                tradeHistoryService.SaveTransaction(tradeHistory);
            }
        }

        return "redirect:/user";

    }







}
