package com.StockTracker.StockTracker.Controllers;

import com.StockTracker.StockTracker.Models.StockPortfolio;
import com.StockTracker.StockTracker.Models.User;
import com.StockTracker.StockTracker.Models.ViewModels.TradeViewModel;
import com.StockTracker.StockTracker.Service.StockPortfolioService;
import com.StockTracker.StockTracker.Service.StockService;
import com.StockTracker.StockTracker.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;



    @RequestMapping()
    public ModelAndView Account(){
        ModelAndView mav = new ModelAndView("account");
        var user = new User();
        mav.addObject("user", user );
        return mav;
    }

    @PostMapping("/createAccount")
    public String SaveUser(@ModelAttribute("user") User user, BindingResult result){

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreateDate(new Date());
        user.setUpdateDate(new Date());

        userService.SaveUser(user);
        return "redirect:/index";

    }


}
