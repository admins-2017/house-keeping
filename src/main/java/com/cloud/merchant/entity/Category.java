package com.cloud.merchant.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@TableName("merchant_category")
@ApiModel(value="Category对象")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "分类主键")
    @TableId(value = "category_id", type = IdType.AUTO)
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
    private Integer createUser;

    @ApiModelProperty(value = "分类更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "分类更新用户")
    private Integer updateUser;


}
