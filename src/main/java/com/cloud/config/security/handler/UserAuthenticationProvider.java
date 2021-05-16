package com.cloud.config.security.handler;

import com.cloud.utils.security.LoginUntil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义登录验证
 * @author 康东伟
 * @date 2021/5/14
 */
@Component
@Slf4j
public class UserAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private LoginUntil loginUntil;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.info("执行登录");
        HttpServletRequest request = ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes())
                .getRequest();
        String type = request.getParameter("type");
        if("1".equals(type)) {
            return loginUntil.loginByUserName(request,authentication);
        }else {
            return loginUntil.loginBySms(request);
        }
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}