package com.StockTracker.StockTracker.Controllers;

import com.StockTracker.StockTracker.Models.User;
import com.StockTracker.StockTracker.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/user")
public class UserController {


    @RequestMapping()
    public ModelAndView User() {
        ModelAndView mav = new ModelAndView("user");
        return mav;
    }

    @RequestMapping("/managecash")
    public ModelAndView ManageCash(){
        ModelAndView mav = new ModelAndView("managecash");
        return  mav;
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
