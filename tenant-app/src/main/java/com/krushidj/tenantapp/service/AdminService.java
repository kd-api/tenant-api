package com.krushidj.tenantapp.service;

import com.krushidj.tenantapp.dao.AdminDAO;
import com.krushidj.tenantapp.entity.LoginEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class AdminService {
    @Autowired
    private AdminDAO adminDAO;

    public LoginEntity create(LoginEntity entity) {


        LoginEntity entity1 = new LoginEntity(entity.getfName(),
                entity.getlName(),
                entity.getEmail(),
                entity.getPhoneNumber(),
                2,
                entity.isActive(),
                entity.getPassword(),
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()));
        adminDAO.save(entity1);
        return entity1;
    }
}