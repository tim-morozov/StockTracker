package com.StockTracker.StockTracker.Controllers;

import com.StockTracker.StockTracker.Models.User;
import com.StockTracker.StockTracker.Models.ViewModels.LoginViewModel;
import com.StockTracker.StockTracker.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

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
    public String LoginUser(@ModelAttribute("Login") LoginViewModel login,
                            HttpSession session,
                            Model model){
        if(ValidateLogin(login)){
            var user = userService.GetUserByUserName(login.getUserName());
            session.setAttribute("user", user);

            return "redirect:/user";
        } else {
            ObjectError error = new ObjectError("globalError", "Invalid Username or Password.");
            login.errorList = new ArrayList<ObjectError>();
            login.errorList.add(error);
            model.addAttribute("login", login);
            return "login";
       }


    }

    private boolean ValidateLogin(LoginViewModel login){
        User validUser = userService.GetUserByUserName(login.getUserName());
        boolean result = false;
        if(validUser != null) {
            result = passwordEncoder.matches(login.getPassword(), validUser.getPassword());
        }

        if (validUser == null){
           return  false;
        } else return result;
    }



}
