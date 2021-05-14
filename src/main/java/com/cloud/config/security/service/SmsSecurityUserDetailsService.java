package com.cloud.config.security.service;


import com.cloud.config.security.entity.SecurityUser;
import com.cloud.sys.entity.User;
import com.cloud.sys.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author 康东伟
 * @date 2021/5/14
 */
@Component
public class SmsSecurityUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public SecurityUser loadUserByUsername(String s) throws UsernameNotFoundException {
        // 查询用户信息
        User user =userService.selectUserByPhoneNumber(s);
        if (user!=null){
            // 组装参数
            SecurityUser securityUser = new SecurityUser();
            BeanUtils.copyProperties(user,securityUser);
            return securityUser;
        }
        return null;
    }
}

