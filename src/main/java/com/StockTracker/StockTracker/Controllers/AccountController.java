package com.StockTracker.StockTracker.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/account")
public class AccountController {

    @RequestMapping()
    public ModelAndView Account(){
        ModelAndView mav = new ModelAndView("account");
        return mav;
    }
}
