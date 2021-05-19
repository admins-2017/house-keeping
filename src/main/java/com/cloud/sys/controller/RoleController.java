package com.cloud.sys.controller;


import com.cloud.sys.service.IRoleService;
import com.cloud.utils.json.JSONResult;
import org.springframework.web.bind.annotation.*;

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
public class RoleController {

    private final IRoleService roleService;

    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public JSONResult addRole(){
        return JSONResult.ok();
    }

    @PutMapping
    public JSONResult updateRole(){
        return JSONResult.ok();
    }

    @DeleteMapping("/{id}")
    public JSONResult removeRole(@PathVariable Long id){
        return JSONResult.ok();
    }

    @PutMapping("/{id}")
    public JSONResult updateDefaultRole(@PathVariable Long id){
        return JSONResult.ok();
    }
}
