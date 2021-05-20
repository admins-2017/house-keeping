package com.cloud.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.bo.UserInfoBO;
import com.cloud.dto.sys.UserWithDeatilDTO;
import com.cloud.sys.entity.Menu;
import com.cloud.sys.entity.Role;
import com.cloud.sys.entity.User;
import com.cloud.sys.entity.UserDetail;
import com.cloud.sys.mapper.UserDetailMapper;
import com.cloud.sys.mapper.UserMapper;
import com.cloud.sys.service.IUserDetailService;
import com.cloud.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.utils.interchangeable.IdWorker;
import com.cloud.vo.sys.UserWithDetailVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    private final IUserDetailService userDetailService;

    public UserServiceImpl(IUserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @Override
    public User selectUserByPhoneNumber(String s) {
        return this.baseMapper.selectUserByPhoneNumber(s);
    }

    @Override
    public List<Role> selectRoleByUserId(Long userId) {
        return this.baseMapper.selectRoleByUserId(userId);
    }

    @Override
    public List<Menu> selectMenuByUserId(Long userId) {
        return this.baseMapper.getMenus(userId);
    }

    @Override
    public UserInfoBO getUserInfo(String loginName) {
        return this.baseMapper.getUserInfo(loginName);
    }

    @Override
    public void addUser(UserWithDeatilDTO dto) {
        long uid = new IdWorker().nextId();
//        新增用户初始密码 123456
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456");
        this.baseMapper.insert(User.builder().userId(uid)
                .loginName(dto.getLoginName()).password(encode).build());
        UserDetail userDetail = new UserDetail();
        BeanUtils.copyProperties(dto,userDetail);
        userDetail.setUserId(uid);
        userDetailService.save(userDetail);
    }

    @Override
    public void updateUser(UserWithDeatilDTO dto) {
        String encode = null;
        if ("".equals(dto.getPassword())){
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            encode = bCryptPasswordEncoder.encode(dto.getPassword());
        }
        this.baseMapper.update(null,new UpdateWrapper<User>().lambda()
                .set(!"".equals(dto.getLoginName()),User::getLoginName,dto.getLoginName())
                .set(!"".equals(dto.getPassword()),User::getPassword,encode)
        );
        userDetailService.update(new UpdateWrapper<UserDetail>().lambda()
                .set(!"".equals(dto.getUserName()),UserDetail::getUserName,dto.getUserName())
                .set(!"".equals(dto.getNickName()),UserDetail::getNickName,dto.getNickName())
                .set(!"".equals(dto.getUserDetailImg()),UserDetail::getUserDetailImg,dto.getUserDetailImg())
                .set(!"".equals(dto.getUserDetailAddress()),UserDetail::getUserDetailAddress,dto.getUserDetailAddress())
                .set(!"".equals(dto.getUserDetailMail()),UserDetail::getUserDetailMail,dto.getUserDetailMail())
                .set(!"".equals(dto.getUserDetailTel()),UserDetail::getUserDetailTel,dto.getUserDetailTel())
                .set(dto.getUserDetailSex()!=null,UserDetail::getUserDetailSex,dto.getUserDetailSex())
                .set(dto.getShopId()!=null,UserDetail::getShopId,dto.getShopId())
                .eq(UserDetail::getUserId,dto.getUserId())
        );
    }

    @Override
    public IPage<UserWithDetailVO> getPage(Integer page, Integer size) {
        Page<UserWithDetailVO> detailVOPage = new Page<>(page, size);
        return this.baseMapper.getPage(detailVOPage);
    }
}
