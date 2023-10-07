package com.songzhou.filter;

import com.songzhou.domain.LoginUser;
import com.songzhou.utils.JwtUtil;
import com.songzhou.utils.RedisCache;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义认证过滤器，解析token，拿到用户信息存到security上下文
 */
@Component
public class MyTokenFilter extends OncePerRequestFilter {
    @Autowired
    private RedisCache redisCache;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //1、获取请求头中的token
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)) {
            //（※以下2行代码为什么这么写）
            filterChain.doFilter(request, response);//这里如果不放行，则登录的时候也会先经过这里，根本无法访问登录接口了
            return;//这里如果不return，则会执行后续代码
        }

        //2、解析token，拿到用户id
        String userid;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userid = claims.getSubject();
        } catch (Exception e) {
            throw new RuntimeException("jwt解析token异常");
        }

        //3、获取用户完整信息，存入security上下文
        LoginUser loginUser = redisCache.getCacheObject("login:" + userid);
        if (ObjectUtils.isEmpty(loginUser))
            throw new RuntimeException("token无效");
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}
