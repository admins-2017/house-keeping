package com.cloud.merchant.service.impl;

import com.cloud.merchant.entity.OrderDetail;
import com.cloud.merchant.mapper.OrderDetailMapper;
import com.cloud.merchant.service.IOrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements IOrderDetailService {

}
