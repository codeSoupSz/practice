package com.songzhou.handler;

import com.alibaba.fastjson.JSON;
import com.songzhou.domain.ResponseResult;
import com.songzhou.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证失败处理
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ResponseResult result = new ResponseResult<>(HttpStatus.UNAUTHORIZED.value(), "认证失败，请重新输入用户名或密码");
        String resultJSON = JSON.toJSONString(result);
        WebUtils.renderString(httpServletResponse,resultJSON);
    }
}
