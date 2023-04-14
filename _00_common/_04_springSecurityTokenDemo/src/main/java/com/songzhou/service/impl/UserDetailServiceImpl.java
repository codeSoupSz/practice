package com.songzhou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.songzhou.domain.LoginUser;
import com.songzhou.domain.User;
import com.songzhou.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.List;

/**
 * 现在不从控制台内存获取密码，而是自定义：从数据库中获取密码比较
 */
@Service
public class UserDetailServiceImpl  implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_name", username));
        if (ObjectUtils.isEmpty(user))
            throw new RuntimeException("登录账号或者密码错误！");
        List<String> permissions = Arrays.asList("test");
        return new LoginUser(user,permissions);
    }
}
