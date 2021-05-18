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
 * @since 2021-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("merchant_service_detail")
@ApiModel(value="ServiceDetail对象", description="服务详情")
public class ServiceDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "服务明细主键")
    @TableId(value = "detail_id",type = IdType.AUTO)
    private Long detailId;

    @ApiModelProperty(value = "预约时间")
    private LocalDateTime reservationTime;

    @ApiModelProperty(value = "预约人 - 顾客")
    private Long reservationUser;

    @ApiModelProperty(value = "预约人联系方式")
    private String reservationTel;

    @ApiModelProperty(value = "门店接单时间")
    private LocalDateTime shopAcceptTime;

    @ApiModelProperty(value = "门店接单人员")
    private Integer shopAcceptUser;

    @ApiModelProperty(value = "门店指派时间")
    private LocalDateTime shopAssignTime;

    @ApiModelProperty(value = "门店指派服务人员")
    private Integer shopAssignUser;

    @ApiModelProperty(value = "服务人员接单时间")
    private LocalDateTime serviceUserTime;

    @ApiModelProperty(value = "服务人员到达时间")
    private LocalDateTime serviceAchieveTime;

    @ApiModelProperty(value = "服务开始时间")
    private LocalDateTime serviceStartTime;

    @ApiModelProperty(value = "服务结束时间")
    private LocalDateTime serviceEndTime;

    @ApiModelProperty(value = "备注信息")
    private String serviceRemark;

    @ApiModelProperty(value = "对应服务订单主键")
    private Long serviceId;
}
