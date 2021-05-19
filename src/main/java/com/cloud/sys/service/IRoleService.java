package com.cloud.sys.service;

import com.cloud.sys.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.vo.sys.MenuVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-11
 */
public interface IRoleService extends IService<Role> {

    /**
     * 根据角色id获取角色所有权限
     * @param id 角色id
     * @return 权限菜单集合
     */
    List<MenuVO> getMenuByRoleId(Long id);
}
