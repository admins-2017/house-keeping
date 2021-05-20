package com.cloud.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * <p>
 * 
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
@ApiModel(value="User对象")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户主键")
    @TableId(value = "user_id", type = IdType.AUTO)
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


}
