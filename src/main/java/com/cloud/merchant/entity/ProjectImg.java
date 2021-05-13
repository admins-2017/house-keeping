package com.cloud.merchant.entity;

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
@TableName("merchant_project_img")
@ApiModel(value="ProjectImg对象", description="")
public class ProjectImg implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "项目详情图片主键")
    @TableId(value = "img_id", type = IdType.AUTO)
    private Integer imgId;

    @ApiModelProperty(value = "图片位置  1 为 顶部轮播图 2 为详情图")
    private Integer imgType;

    @ApiModelProperty(value = "图片路径")
    private String imgUrl;

    @ApiModelProperty(value = "图片状态  0为 删除 1 为正常")
    private Boolean imgStatus;

    @ApiModelProperty(value = "项目id")
    private Integer projectId;


}
