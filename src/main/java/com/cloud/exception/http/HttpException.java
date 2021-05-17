package com.cloud.exception.http;

/**
 * 自定义http 异常
 * @author Administrator
 */
public class HttpException extends RuntimeException{
    /**
     *     异常码
     */
    protected Integer code;
    /**
     *     http异常码 默认500
     */
    protected Integer httpStatusCode = 500;

    public Integer getCode() {
        return code;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }
}
