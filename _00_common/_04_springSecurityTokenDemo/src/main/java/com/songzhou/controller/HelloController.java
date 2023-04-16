package com.songzhou.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
//    @PreAuthorize("hasAuthority('lib:delete')")
    public String hello(){
        return "Hello SpringSecurity";
    }


    @RequestMapping("/testCors")
    @PreAuthorize("hasAuthority('lib:delete')")
    public String testCors(){
        return "Hello testCors";
    }

    @RequestMapping("/testMyExpression")
    @PreAuthorize("@myAuthenticateExpression.ownAuthority('lib')") //※在SPEL表达式中使用 @myAuthenticateExpression相当于获取容器中bean的名字未ex的对象。然后再调用这个对象的ownAuthority方法
    public String testMyExpression(){
        return "Hello testMyExpression";
    }
}
