package com.cloud.vo.sys;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 康东伟
 * @date 2021/5/25
 */
@Data
public class ScheduleJobVO {

    @ApiModelProperty(value = "id",example = "1")
    private Integer id;

    @ApiModelProperty(value = "任务名称")
    private String jobName;

    @ApiModelProperty(value = "任务介绍")
    private String jobIntroduction;

    @ApiModelProperty(value = "表达式")
    private String cronExpression;

    @ApiModelProperty(value = "任务详情id",example = "1")
    private Integer detailId;

    @ApiModelProperty(value = "执行类的bean名称")
    private String beanName;

    @ApiModelProperty(value = "执行方法名称")
    private String methodName;

    @ApiModelProperty(value = "执行方法参数类型")
    private String methodArgType;

    @ApiModelProperty(value = "方法参数")
    private String methodParams;

    @ApiModelProperty(value = "状态 1.启动 2.暂停",example = "1")
    private Integer status;

    @ApiModelProperty(value = "是否删除 0.否 1.是",example = "1")
    private Boolean deleteFlag;

    @ApiModelProperty(value = "创建人id",example = "1")
    private Long creatorId;

    @ApiModelProperty(value = "创建人")
    private String creatorName;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime updatedTime;
}
