package com.krushidj.tenantapp.controller;

import com.krushidj.tenantapp.entity.LoginEntity;
import com.krushidj.tenantapp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1")
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public @ResponseBody
    LoginEntity login(@RequestParam("phone") String phone, @RequestParam("password") String password) throws Exception {
        return loginService.login(phone, password);
    }

}
