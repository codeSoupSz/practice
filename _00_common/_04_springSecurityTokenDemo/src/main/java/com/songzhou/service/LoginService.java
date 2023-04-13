package com.songzhou.service;

import com.songzhou.domain.ResponseResult;
import com.songzhou.domain.User;

public interface LoginService {
    /**
     * 登录实现
     * 1、需要完成用户的验证
     * 2、将用户id生成token返回给前端
     * 3、将用户信息存入Redis
     * @param user
     * @return
     */
    ResponseResult login(User user);

    /**
     * 退出登录
     * 1、从Security上下文获取用户信息
     * 2、去Redis删除对应用户信息
     * @return
     */
    ResponseResult logout();
}
