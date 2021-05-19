package com.cloud.config.jwt;

import com.alibaba.fastjson.JSONObject;
import com.cloud.config.security.entity.SecurityUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * JWT接口请求校验拦截器
 * 请求接口时会进入这里验证Token是否合法和过期
 * @author 康东伟
 * @date 2021/5/14
 */
@Slf4j
public class JWTAuthenticationTokenFilter extends BasicAuthenticationFilter {

    public JWTAuthenticationTokenFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 获取请求头中JWT的Token
        String tokenHeader = request.getHeader(JWTConfig.tokenHeader);
        if (null!=tokenHeader && tokenHeader.startsWith(JWTConfig.tokenPrefix)) {
            String token = tokenHeader.replace(JWTConfig.tokenPrefix, "");
            Claims claims = Jwts.parser()
                    .setSigningKey(JWTConfig.secret)
                    .parseClaimsJws(token)
                    .getBody();
            // 获取用户名
            String username = claims.getSubject();
            String userId=claims.getId();
            if(!StringUtils.isEmpty(username)&&!StringUtils.isEmpty(userId)) {
                // 获取角色
                List<GrantedAuthority> authorities = new ArrayList<>();
                String authority = claims.get("authorities").toString();
                if(!StringUtils.isEmpty(authority)){
                    List<Map<String,String>> authorityMap = JSONObject.parseObject(authority, List.class);
                    for(Map<String,String> role : authorityMap){
                        if(!StringUtils.isEmpty(role)) {
                            authorities.add(new SimpleGrantedAuthority(role.get("authority")));
                        }
                    }
                }
                //组装参数
                SecurityUser securityUser = new SecurityUser();
                securityUser.setUsername(claims.getSubject());
                securityUser.setUserId(Long.parseLong(claims.getId()));
                securityUser.setLoginName(claims.get("login_name").toString());
                securityUser.setAuthorities(authorities);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(securityUser, userId, authorities);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }
}
