package com.cloud.sys.mapper;

import com.cloud.sys.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.vo.sys.MenuVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-11
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据角色id获取权限菜单
     * @param id 角色id
     * @return 权限菜单集合
     */
    List<MenuVO> getMenuByRoleId(@Param("roleId") Long id);
}
