package com.cloud.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_detail")
@ApiModel(value="UserDetail对象", description="")
public class UserDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户详情主键")
    @TableId(value = "user_detail_id", type = IdType.AUTO)
    private Long userDetailId;

    @ApiModelProperty(value = "对应用户的id")
    private Long userId;

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

}
