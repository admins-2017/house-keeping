package com.cloud.merchant.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2021-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("merchant_customer_coupon")
@ApiModel(value="CustomerCoupon对象", description="")
public class CustomerCoupon implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "主键",type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "顾客id")
    private Long customerId;

    @ApiModelProperty(value = "优惠券id")
    private Long couponId;

    @ApiModelProperty(value = "优惠券状态	1 领取未使用	2 已使用	3 已过期")
    private Integer status;

    @ApiModelProperty(value = "优惠券领取时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "优惠券使用时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "使用优惠券订单的id")
    private Integer orderId;


}
