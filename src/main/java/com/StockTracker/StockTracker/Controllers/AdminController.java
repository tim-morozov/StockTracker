package com.StockTracker.StockTracker.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/administrator")
public class AdminController {

    @RequestMapping()
    public ModelAndView Admin(){
        ModelAndView mav = new ModelAndView("administrator");

        return mav;
    }
}
