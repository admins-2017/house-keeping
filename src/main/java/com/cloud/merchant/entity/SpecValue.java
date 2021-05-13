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
@TableName("merchant_spec_value")
@ApiModel(value="SpecValue对象", description="")
public class SpecValue implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "规格值主键")
    @TableId(value = "value_id", type = IdType.AUTO)
    private Integer valueId;

    @ApiModelProperty(value = "规格值名称")
    private String valueName;

    @ApiModelProperty(value = "对应规格名的id")
    private Integer keyId;


}
