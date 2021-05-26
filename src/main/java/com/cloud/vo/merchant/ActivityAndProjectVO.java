package com.cloud.vo.merchant;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 康东伟
 * @date 2021/5/26
 */
@Data
public class ActivityAndProjectVO {

    @ApiModelProperty(value = "项目主键")
    private Long projectId;

    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "项目原价")
    private BigDecimal projectPrice;

    @ApiModelProperty(value = "项目折后价格")
    private BigDecimal projectDiscountPrice;

    @ApiModelProperty(value = "项目描述")
    private String projectDescription;

    @ApiModelProperty(value = "项目状态	1 上线 	2 停用	3 删除")
    private Integer projectStatus;

    @ApiModelProperty(value = "图片路径")
    private String imgUrl;
}
