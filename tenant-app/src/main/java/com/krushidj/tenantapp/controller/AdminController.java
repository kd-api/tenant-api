package com.krushidj.tenantapp.controller;

import com.krushidj.tenantapp.entity.LoginEntity;
import com.krushidj.tenantapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public LoginEntity create(@RequestBody LoginEntity entity) {
        return adminService.create(entity);
    }
}

