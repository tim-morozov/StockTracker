package com.StockTracker.StockTracker.Controllers;

import com.StockTracker.StockTracker.Models.User;
import com.StockTracker.StockTracker.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/user")
    public ModelAndView User() {
        ModelAndView mav = new ModelAndView("user");
        return mav;
    }




}
