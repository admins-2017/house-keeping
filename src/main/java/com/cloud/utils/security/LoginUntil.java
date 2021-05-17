package com.cloud.utils.security;

import com.cloud.config.redis.RedisOperator;
import com.cloud.config.security.entity.SecurityUser;
import com.cloud.config.security.service.SecurityUserDetailsService;
import com.cloud.config.security.service.SmsSecurityUserDetailsService;
import com.cloud.exception.login.LoginCodeException;
import com.cloud.exception.login.LoginResultException;
import com.cloud.sys.entity.Role;
import com.cloud.sys.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * @author 康东伟
 * @date 2021/5/14
 */
@Slf4j
@Component
public class LoginUntil {

    @Autowired
    private SecurityUserDetailsService userDetailsService;
    @Autowired
    private SmsSecurityUserDetailsService smsSecurityUserDetailsService;
    @Autowired
    private IUserService userService;
    @Autowired
    private RedisOperator redisOperator;

    public UsernamePasswordAuthenticationToken loginByUserName(HttpServletRequest request, Authentication authentication ){
        log.info("执行用户名密码登录");
        String code = request.getParameter("code");
        String result = request.getParameter("result");
        // 获取表单输入中返回的用户名
        String userName = (String) authentication.getPrincipal();
        // 获取表单中输入的密码
        String password = (String) authentication.getCredentials();
        // 查询用户是否存在
        SecurityUser securityUser = userDetailsService.loadUserByUsername(userName);
        if (securityUser == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        // 我们还要判断密码是否正确，这里我们的密码使用BCryptPasswordEncoder进行加密的
        if (!new BCryptPasswordEncoder().matches(password, securityUser.getPassword())) {
            throw new BadCredentialsException("密码不正确");
        }

        Set<GrantedAuthority> authorities = getGrantedAuthorities(code, result, securityUser);
        // 进行登录
        return new UsernamePasswordAuthenticationToken(securityUser, password, authorities);
    }

    public UsernamePasswordAuthenticationToken loginBySms(HttpServletRequest request){
        log.info("执行手机验证码登录");
        String code = request.getParameter("code");
        String result = request.getParameter("result");
        String number =request.getParameter("number");

        SecurityUser securityUser = smsSecurityUserDetailsService.loadUserByUsername(number);
        if (securityUser == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        Set<GrantedAuthority> authorities = getGrantedAuthorities(code, result, securityUser);
        return new UsernamePasswordAuthenticationToken(securityUser, "", authorities);
    }

    private Set<GrantedAuthority> getGrantedAuthorities(String code, String result, SecurityUser securityUser) {
        if (!redisOperator.exists(code)) {
            throw new LoginCodeException("验证码不存在,请刷新验证码");
        }
        if (!redisOperator.getString(code).equals(result)) {
            throw new LoginResultException("验证码错误");
        }
        // 还可以加一些其他信息的判断，比如用户账号已停用等判断
        String userStatus = "PROHIBIT";
        if (userStatus.equals(securityUser.getStatus())) {
            throw new LockedException("该用户已被冻结");
        }
        // 还可以加一些其他信息的判断，比如用户账号已停用等判断
        String del = "DEL";
        if (del.equals(securityUser.getStatus())) {
            throw new LockedException("该用户已被删除");
        }
        // 角色集合
        Set<GrantedAuthority> authorities = new HashSet<>();
        // 查询用户角色
        List<Role> roleList = userService.selectRoleByUserId(securityUser.getUserId());
        for (Role role : roleList) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleCode()));
        }
        securityUser.setAuthorities(authorities);
        return authorities;
    }
}

