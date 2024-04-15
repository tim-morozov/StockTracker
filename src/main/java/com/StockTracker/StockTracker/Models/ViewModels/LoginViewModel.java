package com.StockTracker.StockTracker.Models.ViewModels;

import org.springframework.validation.ObjectError;

import java.util.List;

public class LoginViewModel {

    private String userName;

    private String password;

    public List<ObjectError> errorList;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
