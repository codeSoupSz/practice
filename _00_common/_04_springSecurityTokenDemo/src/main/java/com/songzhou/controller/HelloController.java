package com.songzhou.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    @PreAuthorize("hasAuthority('lib:delete')")
    public String hello(){
        return "Hello SpringSecurity";
    }


    @RequestMapping("/testCors")
    @PreAuthorize("hasAuthority('lib:delete')")
    public String testCors(){
        return "Hello testCors";
    }
}
