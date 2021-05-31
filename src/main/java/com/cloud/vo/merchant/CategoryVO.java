package com.cloud.vo.merchant;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 康东伟
 * @date 2021/5/31
 */
@Data
public class CategoryVO {

    @ApiModelProperty(value = "分类主键")
    private Long categoryId;

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

    @ApiModelProperty(value = "分类状态	1 为 正常上线 	2 为 下线")
    private Integer categoryStatus;

    @ApiModelProperty(value = "分类等级")
    private Integer categoryLevel;

    @ApiModelProperty(value = "分类创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "分类创建用户")
    private Long createUser;

    @ApiModelProperty(value = "创建分类用户名称")
    private String createUserName;

    @ApiModelProperty(value = "分类更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "分类更新用户")
    private Long updateUser;

    @ApiModelProperty(value = "修改分类用户名")
    private String updateUserName;

    @ApiModelProperty(value = "下级分类")
    private List<CategoryVO> children = new ArrayList<>(1);
}
