package com.cloud.utils.jwt;

import com.alibaba.fastjson.JSON;
import com.cloud.config.jwt.JWTConfig;
import com.cloud.config.security.entity.SecurityUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author 康东伟
 * @date 2021/5/14
 */
@Slf4j
public class JWTTokenUtil {

    /**
     * 私有化构造器
     */
    private JWTTokenUtil(){}

    /**
     * 生成Token
     * @param   securityUser 用户安全实体
     * @return Token 用户令牌
     */
    public static String createAccessToken(SecurityUser securityUser){
        log.info("生成令牌 security:"+securityUser);
        // 登陆成功生成JWT
        return Jwts.builder()
                // 放入用户名和用户ID
                .setId(securityUser.getUserId()+"")
                // 主题
                .setSubject(securityUser.getUsername())
                // 签发时间
                .setIssuedAt(new Date())
                // 签发者
                .setIssuer("kang")
//                .addClaims(claims)
                // 自定义属性 放入用户拥有权限
                .claim("authorities", JSON.toJSONString(securityUser.getAuthorities()))
                .claim("tenant_id",securityUser.getTenantId())
                .claim("login_name",securityUser.getUsername())
                // 失效时间
                .setExpiration(new Date(System.currentTimeMillis() + JWTConfig.expiration))
                // 签名算法和密钥
                .signWith(SignatureAlgorithm.HS512, JWTConfig.secret)
                .compact();
    }
}
