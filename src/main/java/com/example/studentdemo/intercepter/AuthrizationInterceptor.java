package com.example.studentdemo.intercepter;


import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.studentdemo.bean.constants.Constants;
import com.example.studentdemo.bean.dto.JwtManagerDTO;
import com.example.studentdemo.bean.enums.CodeEnum;
import com.example.studentdemo.bean.res.Result;
import com.example.studentdemo.context.ManagerContext;
import com.example.studentdemo.util.JwtUtil;
import com.example.studentdemo.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class AuthrizationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // log日志打印请求路径
        log.info("请求路径:{}",request.getServletPath());
        /*
         * axios对非简单的请求(比如:Content-Type:application/json)有时会
         * 通过options请求来判断服务端是否支持跨域
         */
        String method = request.getMethod();
        if (HttpMethod.OPTIONS.matches(method)) {
            // 去执行剩余的filter
            return true;
        }

        //获取token
        String tokenToVerify = StringUtils.firstNonBlank(request.getHeader(HttpHeaders.AUTHORIZATION),request.getParameter(Constants.USER_TOKEN_KEY));
        if (StringUtils.isBlank(tokenToVerify)) {
            // 响应失败
            ResponseUtil.respAppJson(response, Result.buildFailure(CodeEnum.AUTH_ERR));
            return false;
        }
        // 校验token
        Result<DecodedJWT> verifyResult = JwtUtil.verify(tokenToVerify);
        if (verifyResult.isFailed()) {
            // 响应失败
            ResponseUtil.respAppJson(response,Result.buildFailure(CodeEnum.AUTH_ERR));
            return false;
        }
        // 从token中还原出放入的对象
        JwtManagerDTO jwtManagerDTO = JwtUtil.parse(verifyResult.getData(), JwtManagerDTO.class);
        if (jwtManagerDTO == null) {
            // 响应失败
            ResponseUtil.respAppJson(response,Result.buildFailure(CodeEnum.AUTH_ERR));
            return false;
        }

        ManagerContext.set(jwtManagerDTO);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ManagerContext.remove();
    }
}