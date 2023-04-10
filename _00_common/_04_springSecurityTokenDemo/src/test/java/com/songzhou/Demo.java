package com.songzhou;

import com.songzhou.domain.User;
import com.songzhou.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Demo {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test01(){
        User user = userMapper.selectById(2);
        System.out.println("user = " + user);
    }
}
