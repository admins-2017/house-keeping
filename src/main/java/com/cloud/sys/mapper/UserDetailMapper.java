package com.cloud.sys.mapper;

import com.cloud.sys.entity.UserDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.vo.LoginSuccessVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-13
 */
public interface UserDetailMapper extends BaseMapper<UserDetail> {

    /**
     * 根据用户id获取用户基本信息
     * @param userId 用户id
     * @return 用户基本信息
     */
    @Select("SELECT\n" +
            "\tsu.user_id,\n" +
            "\tsu.tenant_id,\n" +
            "\tsud.user_name,\n" +
            "\tsud.nick_name,\n" +
            "\tsud.user_detail_img,\n" +
            "\tsud.user_detail_tel,\n" +
            "\tsud.user_detail_sex,\n" +
            "\tsud.user_detail_mail,\n" +
            "\tsud.user_detail_address,\n" +
            "\tms.shop_id,\n" +
            "\tms.shop_name \n" +
            "FROM\n" +
            "\tsys_user su\n" +
            "\tJOIN sys_user_detail sud ON su.user_id = sud.user_id\n" +
            "\tJOIN merchant_shop ms ON sud.shop_id = ms.shop_id \n" +
            "WHERE\n" +
            "\tsu.user_id = #{userId}")
    LoginSuccessVO getUserDetailById(@Param("userId") Integer userId);
}
