package com.songzhou.controller;

import com.songzhou.domain.ResponseResult;
import com.songzhou.domain.User;
import com.songzhou.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/user/login")
    public ResponseResult login(@RequestBody User user){

        return loginService.login(user);
    }
    @RequestMapping("/user/logout")
    public ResponseResult logout(){
        return loginService.logout();
    }
}
