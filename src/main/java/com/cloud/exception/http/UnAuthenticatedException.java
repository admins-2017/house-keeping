package com.cloud.exception.http;

/**
 * 未登录
 * @author Administrator
 */
public class UnAuthenticatedException extends HttpException{

    public UnAuthenticatedException(int code){
        this.code = code;
        this.httpStatusCode = 401;
    }
}
