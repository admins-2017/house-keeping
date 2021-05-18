package com.cloud.bo;

import lombok.Data;

/**
 * @author 康东伟
 * @date 2021/5/17
 */
@Data
public class UserInfoBO {

    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 登录名
     */
    private String loginName;
    /**
     * 密码
     */
    private String password;
    /**
     * 状态:NORMAL正常  PROHIBIT禁用
     */
    private String status;

    /**
     * 多租户标示
     */
    private Long tenantId;
}
