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
@TableName("merchant_spec_key")
@ApiModel(value="SpecKey对象", description="")
public class SpecKey implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "规格名主键")
    @TableId(value = "key_id", type = IdType.AUTO)
    private Integer keyId;

    @ApiModelProperty(value = "规格名称")
    private String keyName;

    @ApiModelProperty(value = "规格单位")
    private String keyUnit;

    @ApiModelProperty(value = "规格描述")
    private String keyDescription;


}
