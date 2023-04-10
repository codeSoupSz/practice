package com.songzhou.controller;

import com.songzhou.domain.ResponseResult;
import com.songzhou.domain.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginController {

    @RequestMapping("/user/login")
    public ResponseResult login(@RequestBody User user){

        return null;
    }
}
