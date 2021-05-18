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
@TableName("merchant_order")
@ApiModel(value="Order对象")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单主键")
    private Long orderId;

    @ApiModelProperty(value = "订单单号")
    private String orderNumber;

    @ApiModelProperty(value = "订单所属用户")
    private Long customerId;

    @ApiModelProperty(value = "订单所属门店")
    private Long shopId;

    @ApiModelProperty(value = "订单总价格")
    private BigDecimal orderTotalPrice;

    @ApiModelProperty(value = "订单项目总数量")
    private Integer orderTotalCount;

    @ApiModelProperty(value = "订单过期时间")
    private LocalDateTime orderExpiredTime;

    @ApiModelProperty(value = "订单下单时间")
    private LocalDateTime orderPlacedTime;

    @ApiModelProperty(value = "微信支付返回id")
    private String prepayId;

    @ApiModelProperty(value = "订单最终金额")
    private BigDecimal orderFinalPrice;

    @ApiModelProperty(value = "订单状态	1 订单发起未支付	2 订单已支付	3 订单已取消	4 订单已过期	5 订单支付失败")
    private Integer orderStatus;

    @ApiModelProperty(value = "订单服务地址")
    private String orderAddress;


}
