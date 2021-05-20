package com.cloud.vo.sys;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 康东伟
 */
@Data
public class UserWithDetailVO {

    @ApiModelProperty(value = "用户主键")
    private Long userId;

    @ApiModelProperty(value = "用户登录名称")
    private String loginName;

    @ApiModelProperty(value = "用户登录密码")
    private String password;

    @ApiModelProperty(value = "用户账号状态 'NORMAL' 正常 'PROHIBIT' 注销  ")
    private String userStatus;

    @ApiModelProperty(value = "预留租户id")
    private Long tenantId;

    @ApiModelProperty(value = "注册时间")
    private LocalDateTime registeredTime;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "用户昵称 如果没有昵称则名称为昵称")
    private String nickName;

    @ApiModelProperty(value = "用户头像")
    private String userDetailImg;

    @ApiModelProperty(value = "用户手机号")
    private String userDetailTel;

    @ApiModelProperty(value = "用户性别 true为男 false为女")
    private Boolean userDetailSex;

    @ApiModelProperty(value = "用户通信地址")
    private String userDetailAddress;

    @ApiModelProperty(value = "用户邮箱")
    private String userDetailMail;

    @ApiModelProperty(value = "用户所在门店id")
    private Long shopId;

    @ApiModelProperty(value = "门店名称")
    private String shopName;
}
