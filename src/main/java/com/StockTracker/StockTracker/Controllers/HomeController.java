package com.StockTracker.StockTracker.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/", "/index"})
public class HomeController {

    @RequestMapping({"/", "/index"})
    public ModelAndView Index(){
        ModelAndView mav = new ModelAndView("index");

        return mav;
    }

    @RequestMapping("/user")
    public ModelAndView User(){
        ModelAndView mav = new ModelAndView("user");
        return  mav;
    }

    @RequestMapping("/administrator")
    public ModelAndView Administrator(){
        ModelAndView mav = new ModelAndView("administrator");
        return  mav;
    }

    @RequestMapping("/account")
    public ModelAndView Account(){
        ModelAndView mav = new ModelAndView("account");
        return  mav;
    }



}
