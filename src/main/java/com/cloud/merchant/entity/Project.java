package com.cloud.merchant.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("merchant_project")
@ApiModel(value="Project对象")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "项目主键")
    @TableId(value = "project_id", type = IdType.AUTO)
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

    @ApiModelProperty(value = "项目标签")
    private String projectTags;

    @ApiModelProperty(value = "分类id")
    private Long categoryId;

    @ApiModelProperty(value = "项目状态	1 上线 	2 停用	3 删除")
    private Integer projectStatus;

    @ApiModelProperty(value = "可视规格主键 对应key表id")
    private Long sketchKeyId;

    @ApiModelProperty(value = "项目默认SKU主键")
    private Long defaultSkuId;


}
