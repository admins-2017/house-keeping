package com.cloud.merchant.entity;

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
 * @since 2021-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("merchant_activity_project")
@ApiModel(value="ActivityProject对象", description="")
public class ActivityProject implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "活动主键")
    private Integer activityId;

    @ApiModelProperty(value = "项目主键")
    private Integer projectId;


}
