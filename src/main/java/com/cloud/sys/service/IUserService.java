package com.cloud.sys.service;

import com.cloud.bo.UserInfoBO;
import com.cloud.sys.entity.Menu;
import com.cloud.sys.entity.Role;
import com.cloud.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-11
 */
public interface IUserService extends IService<User> {

    /**
     * 根据手机号查询用户
     * @param s 手机号
     * @return 用户信息
     */
    User selectUserByPhoneNumber(String s);

    /**
     * 获取用户角色信息
     * @param userId 用户id
     * @return 角色集合
     */
    List<Role> selectRoleByUserId(Integer userId);

    /**
     * 获取用户权限列表
     * @param userId 用户id
     * @return 权限集合
     */
    List<Menu> selectMenuByUserId(Integer userId);

    /**
     * 根据登录名获取用户基本信息
     * @param loginName 登录用户名
     * @return 用户基本信息
     */
    UserInfoBO getUserInfo(String loginName);
}
