package com.cloud.dto.merchant;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 康东伟
 */
@Data
public class CategoryDTO {

    @ApiModelProperty(value = "分类名称")
    private String categoryName;

    @ApiModelProperty(value = "分类描述")
    private String categoryDescription;

    @ApiModelProperty(value = "是否为跟节点 1 为根节点 2 不为根节点")
    private Integer isRoot;

    @ApiModelProperty(value = "父节点id 如果为根节点则为空")
    private Long parentId;

    @ApiModelProperty(value = "分类图片")
    private String categoryImg;

    @ApiModelProperty(value = "分类等级")
    private Integer categoryLevel;
}
