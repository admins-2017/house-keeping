package com.cloud.vo.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@ApiModel(value="菜单对象")
@Data
public class MenuVO {

    @ApiModelProperty(value = "权限主键")
    private Long menuId;

    @ApiModelProperty(value = "权限名称")
    private String menuName;

    @ApiModelProperty(value = "权限表达式")
    private String menuPermission;

    @ApiModelProperty(value = "前端跳转路径")
    private String path;

    @ApiModelProperty(value = "父级id 为0为根目录")
    private Long parentId;

    @ApiModelProperty(value = "目录icon")
    private String menuIcon;

    @ApiModelProperty(value = "菜单类型 （类型   0：目录   1：菜单   2：按钮）")
    private Integer menuType;

    @ApiModelProperty(value = "子集权限菜单")
    private List<MenuVO> children = new ArrayList<>();
}
