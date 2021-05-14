package com.cloud.config.security.handler;

import com.cloud.exception.login.LoginCodeException;
import com.cloud.exception.login.LoginResultException;
import com.cloud.utils.json.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录失败处理类
 * @author 康东伟
 * @date 2021/5/14
 */
@Slf4j
@Component
public class UserLoginFailureHandler implements AuthenticationFailureHandler {
    /**
     * 登录失败返回结果
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception){
        // 这些对于操作的处理类可以根据不同异常进行不同处理
        if (exception instanceof UsernameNotFoundException){
            log.info("【登录失败】"+exception.getMessage());
            JSONResult.responseJson(response, JSONResult.resultCode(500,"用户名不存在"));
        }
        if (exception instanceof LockedException){
            log.info("【登录失败】"+exception.getMessage());
            JSONResult.responseJson(response,JSONResult.resultCode(500,"用户被冻结"));
        }
        if (exception instanceof BadCredentialsException){
            log.info("【登录失败】"+exception.getMessage());
            JSONResult.responseJson(response,JSONResult.resultCode(500,"用户名密码不正确"));
        }
        if (exception instanceof LoginCodeException){
            log.info("【登录失败】"+exception.getMessage());
            JSONResult.responseJson(response,JSONResult.resultCode(500,"验证码超时,请刷新验证码"));
        }
        if (exception instanceof LoginResultException){
            log.info("【登录失败】"+exception.getMessage());
            JSONResult.responseJson(response,JSONResult.resultCode(500,"验证码错误"));
        }
        JSONResult.responseJson(response,JSONResult.resultCode(500,"登录失败,请重新登录"));
    }
}
