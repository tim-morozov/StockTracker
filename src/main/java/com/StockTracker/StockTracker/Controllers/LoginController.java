package com.StockTracker.StockTracker.Controllers;

import com.StockTracker.StockTracker.Models.User;
import com.StockTracker.StockTracker.Models.ViewModels.LoginViewModel;
import com.StockTracker.StockTracker.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping()
    public ModelAndView Login(){
        ModelAndView mav = new ModelAndView("login");
        LoginViewModel login = new LoginViewModel();
        mav.addObject("login", login);

        return mav;
    }

   @PostMapping("/login")
    public ModelAndView LoginUser(@ModelAttribute("Login") LoginViewModel login, HttpSession session){
        if(ValidateLogin(login)){
            var user = userService.GetUserByUserName(login.getUserName());
            session.setAttribute("user", user);
            ModelAndView mav = new ModelAndView("user");
            mav.addObject("user");
            return mav;
        } else {
            return new ModelAndView("index");
       }


    }

    private boolean ValidateLogin(LoginViewModel login){
        User validUser = userService.GetUserByUserName(login.getUserName());
        var result = passwordEncoder.matches(login.getPassword(), validUser.getPassword());

        if (validUser == null){
           return  false;
        } else return result;
    }



}
