package com.songzhou;

import com.songzhou.domain.User;
import com.songzhou.mapper.UserMapper;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
public class Demo {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Test
    public void test01(){
        User user = userMapper.selectById(2);
        System.out.println("user = " + user);
    }
    @Test
    public void testEncrypt(){
        String encode = passwordEncoder.encode("123456");
        System.out.println("encode = " + encode);
    }
    @Test
    public void testQueryForAuthorities(){
        List<String> list = userMapper.queryForAuthorities(3L);
        System.out.println(list);
    }

}
