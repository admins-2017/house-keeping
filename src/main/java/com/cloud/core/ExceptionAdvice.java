package com.cloud.core;

import com.cloud.core.configuration.ExceptionCodeConfiguration;
import com.cloud.exception.http.HttpException;
import com.cloud.utils.json.JSONResult;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 全局捕获异常处理类
 * @author kang
 * @Date 2020-10-07
 * ControllerAdvice 标明该类为异常处理类
 * RestControllerAdvice 该类为异常处理类，并该类的所有方法返回体都格式化为json
 */

@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {

    @Autowired
    private ExceptionCodeConfiguration configuration;

    /**
     * ExceptionHandler 标明该方法为异常处理器 捕获指定的异常进行处理 默认为Exception.class 所有异常
     * value 指定该方法处理哪种异常 传入异常类
     * HttpServletRequest 获取请求路径及方法
     * Exception 因为这里监听的是Exception的异常 所以参数为Exception
     * 如果指定了其他异常处理handle 则不会执行value = exception的handle 如果找不到其他指定的异常处理方法则默认执行该方法
     * ResponseStatus 设置请求返回的http状态码 INTERNAL_SERVER_ERROR为500
     * ResponseBody 将返回的数据json化
     */
    @ExceptionHandler(value= Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public JSONResult handleException(HttpServletRequest request , Exception e){
        return new JSONResult(9999,"服务器内部出错",request.getMethod()+" "+request.getRequestURI());
    }

    /**
     * 处理自定义HttpException 异常
     * @param request 请求体
     * @param e HttpException异常类
     * @return 消息体封装的UnifyResponse返回类
     */
    @ExceptionHandler(HttpException.class)
    public ResponseEntity<JSONResult> handleHttpException(HttpServletRequest request , HttpException e){
//        获取异常code码
        Integer code = e.getCode();
//        获取httpStatus状态码
        Integer httpStatusCode = e.getHttpStatusCode();
        JSONResult jsonResult= new  JSONResult(code,this.getMessageByCode(code),request.getMethod()+" "+request.getRequestURI());
        /*
         * ResponseEntity 定义http返回体
         * 参数1 请求消息响应体
         * 参数2 httpHeaders 请求消息响应体头部
         * 参数3 httpStatus 请求消息响应状态
         */
        HttpHeaders headers = new HttpHeaders();
//        设置返回体的格式
        headers.setContentType(MediaType.APPLICATION_JSON);
//        格式化http返回状态
        HttpStatus status = HttpStatus.resolve(httpStatusCode);
        return new ResponseEntity<>(jsonResult,headers,status);
    }


//
//    /**
//     * 监听自定义校验抛出的异常
//     * @param request 请求
//     * @param e 方法异常
//     * @return 异常结果
//     */
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public UnifyResponse handleBeanValidation(HttpServletRequest request , MethodArgumentNotValidException e){
//        //获取所有未通过验证的异常
//        List<ObjectError> errors = e.getBindingResult().getAllErrors();
//        //将异常信息拼接成字符串
//        String messages = this.formatAllErrorMessages(errors);
//        return new UnifyResponse(10001,messages,request.getMethod()+" "+request.getRequestURI());
//    }
//
//    /**
//     * 监听方法参数校验抛出的异常
//     * @return 异常结果
//     */
//    @ExceptionHandler(ConstraintViolationException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public UnifyResponse handleMethodValidation(HttpServletRequest request , ConstraintViolationException e){
//        return new UnifyResponse(10001,e.getMessage(),request.getMethod()+" "+request.getRequestURI());
//    }
//
//
//
    private String getMessageByCode(Integer code){
        return configuration.getMessage(code);
    }
//
    private String formatAllErrorMessages(List<ObjectError> errors){
        StringBuffer errorMsg = new StringBuffer();
        errors.forEach(error -> errorMsg.append(error.getDefaultMessage()).append(';'));
        return errorMsg.toString();
    }
}
