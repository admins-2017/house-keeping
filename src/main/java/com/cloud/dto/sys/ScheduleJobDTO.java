package com.cloud.dto.sys;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 康东伟
 * @date 2021/5/25
 */
@Data
public class ScheduleJobDTO {

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


}
