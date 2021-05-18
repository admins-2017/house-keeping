package com.cloud.merchant.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("merchant_project_sku")
@ApiModel(value="ProjectSku对象")
public class ProjectSku implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "项目SKU主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "项目SKU名称")
    private String title;

    @ApiModelProperty(value = "项目SKU价格")
    private BigDecimal price;

    @ApiModelProperty(value = "项目SKU折扣价格")
    private BigDecimal discountPrice;

    @ApiModelProperty(value = "是否上线 ")
    private Boolean isOnline;

    @ApiModelProperty(value = "项目SKU展示图片")
    private String img;

    @ApiModelProperty(value = "所属项目主键")
    private Long projectId;

    @ApiModelProperty(value = "规格值")
    private String specs;

    @ApiModelProperty(value = "规格值code码")
    private String code;

    @ApiModelProperty(value = "所属分类id")
    private Long categoryId;

    @ApiModelProperty(value = "员工项目抽成")
    private BigDecimal userRate;


}
