package com.cloud.sys.service;

import com.cloud.sys.entity.UserDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.vo.LoginSuccessVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-13
 */
public interface IUserDetailService extends IService<UserDetail> {

    /**
     * 根据用户id获取用户基本信息
     * @param userId 用户id
     * @return 用户基本信息
     */
    LoginSuccessVO getUserDetailById(Integer userId);
}
