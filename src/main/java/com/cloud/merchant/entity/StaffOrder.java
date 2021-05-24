package com.cloud.merchant.entity;

import java.math.BigDecimal;

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
 * @since 2021-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("merchant_staff_order")
@ApiModel(value="StaffOrder对象", description="服务佣金")
public class StaffOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("员工已完成订单主键")
    @TableId(value = "员工已完成订单主键",type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "服务订单id")
    private Long serviceId;

    @ApiModelProperty(value = "员工id")
    private Long userId;

    @ApiModelProperty(value = "订单佣金")
    private BigDecimal servicePrice;

    @ApiModelProperty(value = "订单完成时间")
    private LocalDateTime createTime;


}
