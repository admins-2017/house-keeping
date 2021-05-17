package com.cloud.sys.controller;


import com.cloud.config.redis.RedisOperator;
import com.cloud.config.security.entity.SecurityUser;
import com.cloud.exception.http.ForbiddenException;
import com.cloud.exception.http.NotFoundException;
import com.cloud.utils.json.JSONResult;
import com.cloud.utils.security.SecurityUntil;
import com.wf.captcha.ArithmeticCaptcha;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-11
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private final RedisOperator redisOperator;

    public UserController(RedisOperator redisOperator) {
        this.redisOperator = redisOperator;
    }

    @ApiOperation("获取验证码")
    @GetMapping(value = "/code")
    public ResponseEntity<Object> getCode(){
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(111, 36);
        // 几位数运算，默认是两位
        captcha.setLen(2);
        // 获取运算的结果
        String result = captcha.text();
        String uuid = "loginCode:"+ UUID.randomUUID().toString();

        System.out.println("result:"+result);
        System.out.println("uuid:"+uuid);

        // 保存
        redisOperator.set(uuid, result,120);
        Map<String,Object> imgResult = new HashMap<String,Object>(2){{
            put("status",200);
            put("img", captcha.toBase64());
            put("uuid", uuid);
        }};
        return ResponseEntity.ok(imgResult);
    }

    @GetMapping("/info/show")
    public JSONResult test(){
        SecurityUser securityUser = SecurityUntil.getUserInfo();
        System.out.println(securityUser);
        return JSONResult.ok();
    }

    @GetMapping("/info/admin")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public JSONResult admin(){
        return JSONResult.ok(SecurityUntil.getUserInfo());
    }

    @GetMapping("/info/user")
    @PreAuthorize("hasAnyRole('user','SUPER_ADMIN')")
    public JSONResult user(){
        return JSONResult.ok(new SecurityUser());
    }

    /**
     * 必须同时拥有SUPER_ADMIN和admin的话
     * @return
     */
    @GetMapping("/helloUser")
    @PreAuthorize("hasRole('SUPER_ADMIN') AND hasRole('user')")
    public String helloUser() {
        return "hello,user";
    }

    @GetMapping("/test/error")
    public String testError() {
        int i = 1/0;
        return "";
    }

    @GetMapping("/test/error2")
    public String testError2() {
        throw new NotFoundException(40001);
    }
}
