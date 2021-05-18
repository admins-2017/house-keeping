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
@TableName("merchant_comment_img")
@ApiModel(value="CommentImg对象")
public class CommentImg implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评论图片主键")
    @TableId(value = "img_id", type = IdType.AUTO)
    private Long imgId;

    @ApiModelProperty(value = "评论图片路径")
    private String imgUrl;

    @ApiModelProperty(value = "评论内容主键")
    private Long commentId;


}
