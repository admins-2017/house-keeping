package com.cloud.merchant.entity;

import java.math.BigDecimal;
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
@TableName("merchant_order_detail")
@ApiModel(value="OrderDetail对象")
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单详情id")
    @TableId(value = "order_detail_id", type = IdType.AUTO)
    private Long orderDetailId;

    @ApiModelProperty(value = "项目 SKU id")
    private Long projectSkuId;

    @ApiModelProperty(value = "项目单价")
    private BigDecimal projectPrice;

    @ApiModelProperty(value = "订单id")
    private Long orderId;


}
