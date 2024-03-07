package com.StockTracker.StockTracker.Controllers;

import com.StockTracker.StockTracker.Models.User;
import com.StockTracker.StockTracker.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    UserService userService;

    @RequestMapping()
    public ModelAndView Account(){
        ModelAndView mav = new ModelAndView("account");
        return mav;
    }

    @PostMapping("/CreateUser")
    public String SaveUser(@Valid User user, BindingResult result, Model model){
        if(result.hasErrors()){
            return "account";
        }

        userService.SaveUser(user);
        return "redirect:/index";

    }

}
