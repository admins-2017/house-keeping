package com.cloud.vo.merchant;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProjectByTagVO {

    private Long projectId;

    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "项目原价")
    private BigDecimal projectPrice;

    @ApiModelProperty(value = "项目折后价格")
    private BigDecimal projectDiscountPrice;

    @ApiModelProperty(value = "项目描述")
    private String projectDescription;

    @ApiModelProperty(value = "项目购买须知")
    private String projectNotice;

    @ApiModelProperty(value = "分类id")
    private Long categoryId;

    @ApiModelProperty(value = "分类名")
    private String categoryName;

    @ApiModelProperty(value = "项目状态	1 上线 	2 停用	3 删除")
    private Integer projectStatus;
}
