package com.cloud.sys.mapper;

import com.cloud.bo.UserInfoBO;
import com.cloud.sys.entity.Menu;
import com.cloud.sys.entity.Role;
import com.cloud.sys.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-11
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据手机号查询用户
     * @param s 手机号
     * @return 用户信息
     */
    @Select("SELECT\n" +
            "\tsu.*\n" +
            "FROM\n" +
            "\tsys_user su\n" +
            "\tJOIN sys_user_detail sud ON su.user_id = sud.user_id \n" +
            "WHERE\n" +
            "\tsud.user_detail_tel = #{tel}")
    User selectUserByPhoneNumber(@Param("tel") String s);

    /**
     * 获取用户角色信息
     * @param userId 用户id
     * @return 角色集合
     */
    @Select("SELECT sr.* FROM sys_role sr\n" +
            "\t\tLEFT JOIN sys_user_role se ON se.role_id = sr.role_id\n" +
            "\t\tWHERE se.user_id = #{userId}")
    List<Role> selectRoleByUserId(@Param("userId") Long userId);

    /**
     * 根据用户id获取权限列表
     * @param userId 用户id
     * @return 权限集合
     */
    List<Menu> getMenus(Long userId);

    /**
     * 根据登录名获取用户基本信息
     * @param loginName 登录名
     * @return 用户基本信息
     */
    @Select("SELECT\n" +
            "\tsu.user_id,\n" +
            "\tsu.login_name,\n" +
            "\tsu.PASSWORD,\n" +
            "\tsu.user_status AS STATUS,\n" +
            "\tsu.tenant_id,\n" +
            "\tsu.registered_time,\n" +
            "\tsud.user_name\n" +
            "FROM\n" +
            "\tsys_user su\n" +
            "\tJOIN sys_user_detail sud ON su.user_id = sud.user_id \n" +
            "WHERE\n" +
            "\tlogin_name = #{name}")
    UserInfoBO getUserInfo(@Param("name") String loginName);
}
