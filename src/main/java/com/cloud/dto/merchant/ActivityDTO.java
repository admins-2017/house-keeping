package com.cloud.dto.merchant;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author 康东伟
 * @date 2021/5/25
 */
@Data
public class ActivityDTO {
    @ApiModelProperty(value = "活动主键")
    private Long activityId;

    @ApiModelProperty(value = "活动名称")
    private String activityName;

    @ApiModelProperty(value = "活动主题")
    private String activityTheme;

    @ApiModelProperty(value = "活动开始时间")
    private String activityStartTime;

    @ApiModelProperty(value = "活动结束时间")
    private String activityEndTime;

    @ApiModelProperty(value = "活动类型	1 满减活动 (指定项目满减)	2 满减折扣 (指定项目 达到满减要求 对总金额进行打折)	3 无条件折扣活动 (指定项目 购买对总金额打折)")
    private Integer activityType;

    @ApiModelProperty(value = "满足条件 ")
    private BigDecimal activityFulfill;

    @ApiModelProperty(value = "减去金额")
    private BigDecimal activityMinus;

    @ApiModelProperty(value = "折扣")
    private Double activityDiscount;

    @ApiModelProperty(value = "活动状态 1 上线 2 下线 3 活动已结束")
    private Integer activityStatus;

}
