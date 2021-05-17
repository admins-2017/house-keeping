package com.cloud.config.security.handler;

import com.cloud.config.jwt.JWTConfig;
import com.cloud.config.security.entity.SecurityUser;
import com.cloud.sys.service.IUserDetailService;
import com.cloud.utils.json.JSONResult;
import com.cloud.utils.jwt.JWTTokenUtil;
import com.cloud.vo.LoginSuccessVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录成功处理类
 * @author kang
 * @date 2020/02/11
 */
@Slf4j
@Component
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private IUserDetailService detailService;

    /**
     * 登录成功返回结果
     * SysLoginLog
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication){
        /*
         组装JWT
         */
        SecurityUser userEntity =  (SecurityUser) authentication.getPrincipal();
        log.info("userEntity:"+userEntity);
        String token = JWTTokenUtil.createAccessToken(userEntity);
        token = JWTConfig.tokenPrefix + token;
        //为前端提供返回vo
        LoginSuccessVO successVo;
        successVo = detailService.getUserDetailById(userEntity.getUserId());
        successVo.setToken(token);

        // 封装返回参数
        Map<String,Object> resultData = new HashMap<>(3);
        resultData.put("meta", JSONResult.login());
        resultData.put("data",successVo);
        resultData.put("code",200);

        JSONResult.responseJson(response,resultData);
    }
}
