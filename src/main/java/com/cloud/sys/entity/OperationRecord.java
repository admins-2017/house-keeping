package com.cloud.sys.entity;

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
@TableName("sys_operation_record")
@ApiModel(value="OperationRecord对象", description="")
public class OperationRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "操作记录主键")
    @TableId(value = "record_id", type = IdType.AUTO)
    private Integer recordId;

    @ApiModelProperty(value = "请求方式")
    private String requestType;

    @ApiModelProperty(value = "请求路径")
    private String requestUrl;

    @ApiModelProperty(value = "操作人")
    private String requestUser;

    @ApiModelProperty(value = "操作时间")
    private LocalDateTime requestTime;

    @ApiModelProperty(value = "请求IP地址")
    private String requestIp;

    @ApiModelProperty(value = "请求方法描述")
    private String requestDescription;


}
