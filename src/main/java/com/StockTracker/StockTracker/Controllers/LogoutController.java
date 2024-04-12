package com.StockTracker.StockTracker.Controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    @RequestMapping()
    public String Logout(HttpSession session){
        session.invalidate();

        return "redirect:/";
    }
}
