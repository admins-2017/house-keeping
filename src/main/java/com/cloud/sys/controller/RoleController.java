package com.cloud.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.dto.sys.RoleDTO;
import com.cloud.sys.entity.Role;
import com.cloud.sys.service.IRoleService;
import com.cloud.utils.interchangeable.ParseMenuTreeUtil;
import com.cloud.utils.json.JSONResult;
import com.cloud.vo.sys.MenuVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-11
 */
@RestController
@RequestMapping("/role")
@Api(value="角色控制类",tags = "角色控制类")
@Slf4j
public class RoleController {

    private final IRoleService roleService;

    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }

    @ApiOperation(value = "新增角色信息")
    @PostMapping
    public JSONResult addRole(@RequestBody RoleDTO dto){
        Role role = new Role();
        BeanUtils.copyProperties(dto,role);
        roleService.save(role);
        return JSONResult.ok("新建角色成功");
    }

    @ApiOperation(value = "修改角色信息")
    @PutMapping
    public JSONResult updateRole(@RequestBody RoleDTO dto){
        roleService.update(new UpdateWrapper<Role>().lambda()
                .set(!"".equals(dto.getRoleCode()),Role::getRoleCode,dto.getRoleCode())
                .set(!"".equals(dto.getRoleDescription()),Role::getRoleDescription,dto.getRoleDescription())
                .set(!"".equals(dto.getRoleName()),Role::getRoleName,dto.getRoleName())
                .eq(Role::getRoleId,dto.getRoleId())
        );
        return JSONResult.ok("修改角色信息成功");
    }

    @ApiOperation(value = "删除角色信息")
    @DeleteMapping("/{id}")
    public JSONResult removeRole(@PathVariable Long id){
        roleService.update(new UpdateWrapper<Role>().lambda()
            .set(Role::getDelFlag,1)
            .eq(Role::getRoleId,id)
        );
        return JSONResult.ok("角色已删除");
    }

    @ApiOperation(value = "修改默认角色")
    @PutMapping("/{id}")
    public JSONResult updateDefaultRole(@PathVariable Long id){
        roleService.update(new UpdateWrapper<Role>()
                .setSql("default_role = 0 WHERE default_role = 1"));
         roleService.update(new UpdateWrapper<Role>().lambda()
                .set(Role::getDefaultRole, 1).eq(Role::getRoleId, id));
        return JSONResult.ok("修改默认角色完成");
    }

    @ApiOperation(value = "分页获取角色")
    @GetMapping("/{page}/{size}")
    public JSONResult getRoleByPage(@PathVariable Integer page,@PathVariable Integer size){
        Page<Role> rolePage = new Page<>(page,size);
        Page<Role> pages = roleService.page(rolePage, new QueryWrapper<Role>().lambda()
                .eq(Role::getDelFlag, false));
        return JSONResult.ok(pages);
    }

    @ApiOperation(value = "获取角色的权限菜单")
    @GetMapping("/{id}")
    public JSONResult getMenuByRoleId(@PathVariable Long id){
        List<MenuVO> vos = roleService.getMenuByRoleId(id);
        List<MenuVO> menuVOS = ParseMenuTreeUtil.parseMenuTree(vos);
        return JSONResult.ok(menuVOS);
    }
}
