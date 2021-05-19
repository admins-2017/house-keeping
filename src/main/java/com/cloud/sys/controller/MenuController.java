package com.cloud.sys.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cloud.dto.sys.MenuDTO;
import com.cloud.sys.entity.Menu;
import com.cloud.sys.service.IMenuService;
import com.cloud.utils.json.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author 康东伟
 * @since 2021-05-13
 */
@RestController
@RequestMapping("/menu")
@Slf4j
public class MenuController {

    private final IMenuService menuService;

    public MenuController(IMenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping
    public JSONResult addMenu(@RequestBody MenuDTO dto){
        log.info("dto:{}",dto);
        Menu menu = new Menu();
        BeanUtils.copyProperties(dto,menu);
        menuService.save(menu);
        return JSONResult.ok("添加菜单成功");
    }

    @DeleteMapping("/{id}")
    public JSONResult removeMenu(@PathVariable Long id){
        menuService.update(new UpdateWrapper<Menu>().lambda().set(Menu::getDelFlag,true).eq(Menu::getMenuId,id));
        return JSONResult.ok("删除菜单成功");
    }

    @PutMapping
    public JSONResult updateMenu(@RequestBody MenuDTO dto){
        log.info("dto:{}",dto);
        menuService.update(new UpdateWrapper<Menu>().lambda()
                .set(dto.getMenuName()!="",Menu::getMenuName,dto.getMenuName())
                .set(dto.getMenuPermission()!="",Menu::getMenuPermission,dto.getMenuPermission())
                .set(dto.getMenuIcon()!="",Menu::getMenuIcon,dto.getMenuIcon())
                .set(dto.getPath()!="",Menu::getPath,dto.getPath())
                .set(dto.getMenuType()!=null&&dto.getMenuType()>0,Menu::getMenuType,dto.getMenuType())
                .set(dto.getParentId()!=null&&dto.getParentId()>0,Menu::getParentId,dto.getParentId())
                .eq(Menu::getMenuId,dto.getMenuId())
        );
        return JSONResult.ok("修改菜单成功");
    }

}
