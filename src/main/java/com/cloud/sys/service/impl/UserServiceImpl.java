package com.cloud.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.sys.entity.Menu;
import com.cloud.sys.entity.Role;
import com.cloud.sys.entity.User;
import com.cloud.sys.mapper.UserMapper;
import com.cloud.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User selectUserByPhoneNumber(String s) {
        return this.baseMapper.selectUserByPhoneNumber(s);
    }

    @Override
    public List<Role> selectRoleByUserId(Integer userId) {
        return this.baseMapper.selectRoleByUserId(userId);
    }

    @Override
    public List<Menu> selectMenuByUserId(Integer userId) {
        return this.baseMapper.getMenus(userId);
    }
}
