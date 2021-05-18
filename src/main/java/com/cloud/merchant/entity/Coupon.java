package com.cloud.merchant.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
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
@TableName("merchant_coupon")
@ApiModel(value="Coupon对象")
public class Coupon implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "优惠券主键")
    private Long couponId;

    @ApiModelProperty(value = "优惠券名称")
    private String couponName;

    @ApiModelProperty(value = "优惠券使用开始时间")
    private LocalDateTime couponStartTime;

    @ApiModelProperty(value = "优惠券使用结束时间")
    private LocalDateTime couponEndTime;

    @ApiModelProperty(value = "优惠券使用说明")
    private String couponDescription;

    @ApiModelProperty(value = "优惠券类型	1 满减 (全场或指定项目满足条件 进行减去)	2 满折 (全场或指定项目满足条件 进行总金额折扣)	3 折扣 (全场或指定项目 结算对总金额进行折扣)")
    private Integer couponType;

    @ApiModelProperty(value = "是否为全场券")
    private Boolean couponIsAll;

    @ApiModelProperty(value = "满减条件")
    private BigDecimal couponFull;

    @ApiModelProperty(value = "减去金额")
    private BigDecimal couponMinus;

    @ApiModelProperty(value = "折扣率")
    private Double couponRate;

    @ApiModelProperty(value = "优惠券简介")
    private String couponRemark;

    @ApiModelProperty(value = "优惠券状态 1 上线 2 停用")
    private Integer couponStatus;

    @ApiModelProperty(value = "优惠券发放数量")
    private Integer couponNumber;


}
