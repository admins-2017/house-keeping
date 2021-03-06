package com.cloud.merchant.service;

import com.cloud.dto.merchant.CouponDTO;
import com.cloud.merchant.entity.Coupon;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-13
 */
public interface ICouponService extends IService<Coupon> {


    /**
     * 新增优惠券
     * @param dto 优惠券实体
     * @return 更新条数
     */
    int addCoupon(CouponDTO dto);
}
