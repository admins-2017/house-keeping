package com.cloud.merchant.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

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
@ApiModel(value="ActivityProject对象")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityProject implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "主键",type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "活动主键")
    private Long activityId;

    @ApiModelProperty(value = "项目主键")
    private Long projectId;

    public ActivityProject(Long activityId, Long projectId) {
        this.activityId = activityId;
        this.projectId = projectId;
    }
}
