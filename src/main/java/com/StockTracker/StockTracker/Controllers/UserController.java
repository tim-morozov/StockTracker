package com.StockTracker.StockTracker.Controllers;

import com.StockTracker.StockTracker.Models.User;
import com.StockTracker.StockTracker.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping()
    public ModelAndView User() {
        ModelAndView mav = new ModelAndView("user");
        return mav;
    }

    @RequestMapping("/managecash")
    public ModelAndView ManageCash(HttpSession session){
        ModelAndView mav = new ModelAndView("managecash");
        var user = session.getAttribute("user");
        mav.addObject("user",user);
        return  mav;
    }

    @PostMapping("/processDeposit")
    public ModelAndView ProcessDeposit(@RequestParam("NewBalance") Float NewBalance, BindingResult result, HttpSession session){
        User user = (User)session.getAttribute("user");
        user.setBalance(NewBalance);
        userService.SaveUser(user);

        ModelAndView mav = new ModelAndView("user");
        return mav;
    }

    @PostMapping("/processWithdraw")
    public ModelAndView ProcessWithdraw(@RequestParam("WithdrawBalance") float withdrawBalance, HttpSession session){
        User user = (User)session.getAttribute("user");
        var newBalance = user.getBalance() - withdrawBalance;
        user.setBalance(newBalance);

        userService.SaveUser(user);

        ModelAndView mav = new ModelAndView("user");
        return mav;
    }



    @RequestMapping("/viewusertradinghistory")
    public ModelAndView ViewUserTradingHistory(){
        ModelAndView mav = new ModelAndView("viewusertradinghistory");
        return  mav;
    }

    @RequestMapping("/makeatrade")
    public ModelAndView MakeATrade(){
        ModelAndView mav = new ModelAndView("makeatrade");
        return mav;
    }



}
