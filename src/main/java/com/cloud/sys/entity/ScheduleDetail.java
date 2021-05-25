package com.cloud.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2021-05-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_schedule_detail")
@ApiModel(value="任务详情对象")
public class ScheduleDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "主键",type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "执行类的bean名称")
    private String beanName;

    @ApiModelProperty(value = "执行方法名称")
    private String methodName;

    @ApiModelProperty(value = "执行方法参数类型")
    private String methodArgType;

    @ApiModelProperty(value = "执行方法介绍")
    private String methodIntroduction;


}
