package com.cloud.exception.http;

/**
 * @author Administrator
 */
public class ParameterException extends HttpException {
    public ParameterException(Integer code){
        this.code =code;
        this.httpStatusCode =400;
    }
}
