package com.StockTracker.StockTracker.Controllers;

import com.StockTracker.StockTracker.Models.User;
import com.StockTracker.StockTracker.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Users")
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping("/login")
//    public void Login(){
//        return;
//    }

    @GetMapping("AllUsers")
    public List<User> GetAllUsers(){
        return  userService.GetAllUsers();
    }

    @GetMapping("/GetUser/{id}")
    public User GetUser(@PathVariable short id){
        return userService.GetUser(id);
    }

    @PostMapping("NewUser")
    public void SaveUser(@RequestBody User user){

        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmailAddress(user.getEmailAddress());
        newUser.setUserType(user.getUserType());
        newUser.setMarketId(user.getMarketId());
        newUser.setCreateDate(Date.from(Instant.now()));
        newUser.setUpdateDate(Date.from(Instant.now()));

        userService.SaveUser(newUser);
    }
}
