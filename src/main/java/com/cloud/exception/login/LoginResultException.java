package com.cloud.exception.login;

import org.springframework.security.core.AuthenticationException;

/**
 * @author 康东伟
 * @date 2021/5/14
 */
public class LoginResultException extends AuthenticationException {

    public LoginResultException(String msg) {
        super(msg);
    }
}
