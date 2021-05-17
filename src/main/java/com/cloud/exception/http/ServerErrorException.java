package com.cloud.exception.http;

/**
 * @author Administrator
 * 服务器未知异常
 */
public class ServerErrorException extends HttpException {

    public ServerErrorException(Integer code){
        this.code =code;
        this.httpStatusCode =500;
    }
}
