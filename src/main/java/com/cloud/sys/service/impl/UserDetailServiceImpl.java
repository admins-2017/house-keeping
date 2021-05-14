package com.cloud.sys.service.impl;

import com.cloud.sys.entity.UserDetail;
import com.cloud.sys.mapper.UserDetailMapper;
import com.cloud.sys.service.IUserDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.vo.LoginSuccessVO;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-13
 */
@Service
public class UserDetailServiceImpl extends ServiceImpl<UserDetailMapper, UserDetail> implements IUserDetailService {

    @Override
    public LoginSuccessVO getUserDetailById(Integer userId) {
        return this.baseMapper.getUserDetailById(userId);
    }
}
