package com.cloud.sys.service.impl;

import com.cloud.sys.entity.Role;
import com.cloud.sys.mapper.RoleMapper;
import com.cloud.sys.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.vo.sys.MenuVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 康东伟
 * @since 2021-05-11
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public List<MenuVO> getMenuByRoleId(Long id) {
        return this.baseMapper.getMenuByRoleId(id);
    }
}
