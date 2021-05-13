package com.cloud.merchant.entity;

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
@TableName("merchant_service")
@ApiModel(value="Service对象", description="")
public class ServiceOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "服务订单主键")
    private Integer serviceId;

    @ApiModelProperty(value = "订单id")
    private Integer orderId;

    @ApiModelProperty(value = "项目id")
    private Integer projectId;

    @ApiModelProperty(value = "预约时间")
    private LocalDateTime reservationTime;

    @ApiModelProperty(value = "服务地址")
    private String serviceAddress;

    @ApiModelProperty(value = "服务状态 	1 已预约 未服务	2 已完成	3 已取消")
    private Integer serviceStatus;

    @ApiModelProperty(value = "服务单备注")
    private String serviceRemark;


}
