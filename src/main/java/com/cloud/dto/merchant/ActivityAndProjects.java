package com.cloud.dto.merchant;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author 康东伟
 * @date 2021/5/27
 */
@Data
public class ActivityAndProjects {

    @ApiModelProperty("活动id")
    private Long activityId;

    @ApiModelProperty("项目id")
    private List<Long> projectIds;
}
