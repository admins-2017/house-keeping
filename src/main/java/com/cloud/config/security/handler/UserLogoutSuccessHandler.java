package com.cloud.config.security.handler;

import com.cloud.utils.json.JSONResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 登出成功处理类
 * @author 康东伟
 * @date 2021/5/14
 */
@Component
public class UserLogoutSuccessHandler implements LogoutSuccessHandler {
    /**
     * 用户登出返回结果
     * 这里应该让前端清除掉Token
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication){
        Map<String,Object> resultData = new HashMap<>(2);
        resultData.put("code","200");
        resultData.put("msg", "登出成功");
        /*
         * 清空权限信息
         */
        SecurityContextHolder.clearContext();
        JSONResult.responseJson(response,JSONResult.resultSuccess(resultData));
    }
}
