package com.prac.random.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/random")
@RestController
public class RandomNameController {
    @GetMapping("/name")
    public String getRandomName(){
        List<String> studentsList = Arrays.asList("张三", "李四", "王五", "赵六", "宋七");
        String name = studentsList.get((int) (Math.random() * 5));
        return name;
    }
}
