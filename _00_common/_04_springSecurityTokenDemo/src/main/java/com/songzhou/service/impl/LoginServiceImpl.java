package com.songzhou.service.impl;

import com.songzhou.domain.LoginUser;
import com.songzhou.domain.ResponseResult;
import com.songzhou.domain.User;
import com.songzhou.service.LoginService;
import com.songzhou.utils.JwtUtil;
import com.songzhou.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redis;
    @Override
    public ResponseResult login(User user) {
        //1、完成用户信息验证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        //如果权限认证后返回的权限对象为空，则表示登录失败
        if (ObjectUtils.isEmpty(authentication))
            throw new RuntimeException("登录失败");

        //2、将用户信息存入Redis
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userid = loginUser.getUser().getId();
        redis.setCacheObject("login:"+userid,loginUser);
        //3、借助jwt将用户id生成一个token返回给前端
        String token = JwtUtil.createJWT(String.valueOf(userid));
        Map resultMap = new HashMap<String,Object>();
        resultMap.put("token",token);
        ResponseResult result = new ResponseResult<>(200,"登录成功",resultMap);
        return result;
    }
}
