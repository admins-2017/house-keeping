package com.cloud.exception.login;

import org.springframework.security.core.AuthenticationException;

/**
 * @author 康东伟
 * @date 2021/5/14
 */
public class LoginCodeException extends AuthenticationException {

    public LoginCodeException(String msg) {
        super(msg);
    }
}

