package com.cloud.merchant.service.impl;

import com.cloud.dto.merchant.CouponDTO;
import com.cloud.merchant.entity.Coupon;
import com.cloud.merchant.mapper.CouponMapper;
import com.cloud.merchant.service.ICouponService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
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
public class CouponServiceImpl extends ServiceImpl<CouponMapper, Coupon> implements ICouponService {


    @Override
    public int addCoupon(CouponDTO dto) {
        Coupon coupon = new Coupon();
        BeanUtils.copyProperties(dto,coupon);
        return this.baseMapper.insert(coupon);
    }
}
