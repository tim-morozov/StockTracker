package com.StockTracker.StockTracker.Service;

import com.StockTracker.StockTracker.Repository.UserRepository;
import com.StockTracker.StockTracker.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User GetUser(short id){
        var user = userRepository.findById(id);

        return (User) user;
    }

    public List<User> GetAllUsers(){
        var users = userRepository.findAll();

        return (List<User>) users;
    }

    public void SaveUser(User user){
        userRepository.save(user);
    }


}
