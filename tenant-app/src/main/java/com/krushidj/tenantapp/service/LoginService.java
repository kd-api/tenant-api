package com.krushidj.tenantapp.service;

import com.krushidj.tenantapp.dao.LoginDAO;
import com.krushidj.tenantapp.entity.LoginEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginDAO loginDAO;

    public LoginEntity login(String phone, String password) throws Exception{

        LoginEntity loginEntity= loginDAO.login(phone,password);
        loginEntity.setPassword(null);
        return loginEntity;

    }
}
