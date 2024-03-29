package com.songzhou.handler;

import com.alibaba.fastjson.JSON;
import com.songzhou.domain.ResponseResult;
import com.songzhou.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 鉴权失败处理
 */
@Component
public class AccessDeniedHandlerImpl  implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        ResponseResult result = new ResponseResult<>(HttpStatus.FORBIDDEN.value(),  "权限不足");
        String resultJSON = JSON.toJSONString(result);
        WebUtils.renderString(httpServletResponse,resultJSON);
    }
}
