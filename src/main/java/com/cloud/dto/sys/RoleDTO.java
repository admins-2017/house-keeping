package com.cloud.dto.sys;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 康东伟
 * @date 2021/5/19
 */
@Data
public class RoleDTO {

    @ApiModelProperty(value = "角色主键")
    private Long roleId;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "角色描述")
    private String roleDescription;

    @ApiModelProperty(value = "角色编码")
    private String roleCode;
}
