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
@TableName("merchant_shop")
@ApiModel(value="Shop对象", description="")
public class Shop implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "门店主键")
    @TableId(value = "shop_id", type = IdType.AUTO)
    private Integer shopId;

    @ApiModelProperty(value = "门店名称")
    private String shopName;

    @ApiModelProperty(value = "门店地址")
    private String shopAddress;

    @ApiModelProperty(value = "门店联系方式")
    private String shopTel;

    @ApiModelProperty(value = "门店状态	1 营业	2 休息	3 关闭")
    private Integer shopStatus;

    @ApiModelProperty(value = "预留租户id")
    private Integer tenantId;


}
