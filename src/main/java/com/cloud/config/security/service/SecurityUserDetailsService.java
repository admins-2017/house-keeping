package com.cloud.config.security.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.config.security.entity.SecurityUser;
import com.cloud.sys.entity.User;
import com.cloud.sys.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * SpringSecurity用户的业务实现
 * @author 康东伟
 * @date 2021/5/14
 */
@Component
public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    /**
     * 查询用户信息
     * @param   username  用户名
     * @return  UserDetails SpringSecurity用户信息
     */
    @Override
    public SecurityUser loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户信息
        User user =userService.getOne(new QueryWrapper<User>().lambda().eq(User::getLoginName,username));
        if (user!=null){
            // 组装参数
            SecurityUser securityUser = new SecurityUser();
            BeanUtils.copyProperties(user,securityUser);
            return securityUser;
        }
        return null;
    }
}