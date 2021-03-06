package com.cloud.merchant.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.cloud.dto.merchant.ActivityDTO;
import com.cloud.utils.interchangeable.LocalDateTimeUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author 康东伟
 * @since 2021-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("merchant_activity")
@ApiModel(value="活动实体")
@NoArgsConstructor
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "活动主键")
    @TableId(value = "activity_id", type = IdType.AUTO)
    private Long activityId;

    @ApiModelProperty(value = "活动名称")
    private String activityName;

    @ApiModelProperty(value = "活动主题")
    private String activityTheme;

    @ApiModelProperty(value = "活动开始时间")
    private LocalDateTime activityStartTime;

    @ApiModelProperty(value = "活动结束时间")
    private LocalDateTime activityEndTime;

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

    @ApiModelProperty(value = "活动备注")
    private String activityRemark;

    public Activity(ActivityDTO dto) {
        this.activityId = dto.getActivityId();
        this.activityName = dto.getActivityName();
        this.activityTheme = dto.getActivityTheme();
        this.activityStartTime = LocalDateTimeUtil.parseStringToDateTime(dto.getActivityStartTime(),"yyyy-MM-dd HH:mm:ss");
        this.activityEndTime = LocalDateTimeUtil.parseStringToDateTime(dto.getActivityEndTime(),"yyyy-MM-dd HH:mm:ss");
        this.activityType = dto.getActivityType();
        this.activityFulfill = dto.getActivityFulfill();
        this.activityMinus = dto.getActivityMinus();
        this.activityDiscount = dto.getActivityDiscount();
        this.activityStatus = dto.getActivityStatus();
        this.activityRemark = dto.getActivityRemark();
    }
}
