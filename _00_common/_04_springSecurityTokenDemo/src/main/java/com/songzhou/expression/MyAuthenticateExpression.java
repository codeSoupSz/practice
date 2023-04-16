package com.songzhou.expression;

import com.songzhou.domain.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义鉴权规则
 */
@Component
public class MyAuthenticateExpression {
    public boolean ownAuthority(String authority){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        List<String> permissions = loginUser.getPermissions();
        for (String permission : permissions) {
            if (permission.startsWith(authority)) {
                return true;
            }
        }
        return false;
    }
}
