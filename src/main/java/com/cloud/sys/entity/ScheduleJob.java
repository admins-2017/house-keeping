package com.cloud.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.cloud.merchant.entity.Activity;
import com.cloud.utils.interchangeable.LocalDateTimeUtil;
import com.cloud.utils.security.SecurityUntil;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_schedule_job")
@ApiModel(value="任务对象", description="")
@NoArgsConstructor
public class ScheduleJob implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "任务名称")
    private String jobName;

    @ApiModelProperty(value = "任务介绍")
    private String jobIntroduction;

    @ApiModelProperty(value = "CRON 表达式")
    private String cronExpression;

    @ApiModelProperty(value = "任务详情id")
    private Long detailId;

    @ApiModelProperty(value = "方法参数")
    private String methodParams;

    @ApiModelProperty(value = "状态 1.启动 2.暂停")
    private Integer status;

    @ApiModelProperty(value = "是否删除 0.否 1.是")
    private Boolean deleteFlag;

    @ApiModelProperty(value = "创建人id")
    private Long creatorId;

    @ApiModelProperty(value = "创建人")
    private String creatorName;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime updatedTime;

    public ScheduleJob(Activity activity) {
        this.jobName = activity.getActivityName();
        this.jobIntroduction = activity.getActivityRemark();
        this.cronExpression = LocalDateTimeUtil.getDateTimeAsCron(activity.getActivityEndTime());
        this.detailId = 3L;
        this.methodParams = activity.getActivityId().toString();
        this.creatorId = SecurityUntil.getUserId();
        this.creatorName = SecurityUntil.getUserName();
        this.createdTime = activity.getActivityStartTime();
    }
}
