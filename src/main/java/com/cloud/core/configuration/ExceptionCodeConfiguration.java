package com.cloud.core.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * PropertySource 将properties文件和类对应 读取properties文件
 * 读取 exception-code.properties
 * ConfigurationProperties 读取指定前缀的key和value进行绑定 绑定到map中
 * prefix 指定前缀
 * @author 康东伟
 * @date 2021/5/17
 */
@PropertySource(value = "classpath:config/exception-code.properties")
@ConfigurationProperties(prefix = "http")
@Component
public class ExceptionCodeConfiguration {

    /**
     * codes 对应的是properties的keyName
     */
    private Map<Integer,String> codes = new HashMap<>();

    public String getMessage(Integer code){
        return codes.get(code);
    }

    public Map<Integer, String> getCodes() {
        return codes;
    }

    public void setCodes(Map<Integer, String> codes) {
        this.codes = codes;
    }
}
