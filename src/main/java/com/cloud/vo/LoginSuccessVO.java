package com.cloud.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 康东伟
 * @date 2021/5/14
 */
@Data
public class LoginSuccessVO {

    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 多租户标示
     */
    private Long tenantId;

    private String token;

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

    @ApiModelProperty(value = "所属商铺名称")
    private String shopName;
}
