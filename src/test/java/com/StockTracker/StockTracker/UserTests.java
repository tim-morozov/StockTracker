package com.StockTracker.StockTracker;

import com.StockTracker.StockTracker.Models.User;
import com.StockTracker.StockTracker.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void TestFindUsername(){
        User user = userRepository.findUserByUserName("Bill123");

        assertNotNull(user);
    }
}
