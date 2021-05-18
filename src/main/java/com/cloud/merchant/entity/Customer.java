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
 * @since 2021-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("merchant_customer")
@ApiModel(value="Customer对象", description="顾客详情")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "顾客主键")
    @TableId(value = "customer_id", type = IdType.AUTO)
    private Long customerId;

    @ApiModelProperty(value = "顾客名字 true 为男")
    private String customerName;

    @ApiModelProperty(value = "顾客性别")
    private Boolean customerSex;

    @ApiModelProperty(value = "顾客联系方式")
    private String customerTel;

    @ApiModelProperty(value = "顾客联系地址")
    private String customerAddress;

    @ApiModelProperty(value = "顾客生日")
    private LocalDateTime customerBirthday;


}
