package com.cloud.dto.merchant;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 康东伟
 */
@Data
public class UpdateCategoryDTO {
    private Long categoryId;

    @ApiModelProperty(value = "分类名称")
    private String categoryName;

    @ApiModelProperty(value = "分类描述")
    private String categoryDescription;

    @ApiModelProperty(value = "分类图片")
    private String categoryImg;
}
