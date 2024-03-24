package com.StockTracker.StockTracker.Controllers;

import com.StockTracker.StockTracker.Models.User;
import com.StockTracker.StockTracker.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


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
        return new ModelAndView("makeatrade");
    }





}
