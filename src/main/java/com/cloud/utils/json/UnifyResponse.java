package com.cloud.utils.json;

import lombok.Getter;
import lombok.Setter;

/**
 * 异常返回类
 * @author Administrator
 */
@Getter
@Setter
public class UnifyResponse {
    /**
     * 返回状态码
     */
    private Integer code;
    /**
     * 错误信息
     */
    private String message;
    /**
     * 请求路径及方法
     */
    private String request;

    public UnifyResponse(Integer code, String message, String request) {
        this.code = code;
        this.message = message;
        this.request = request;
    }


}
