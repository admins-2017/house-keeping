package com.cloud.merchant.service.impl;

import com.cloud.merchant.entity.ServiceOrder;
import com.cloud.merchant.mapper.ServiceMapper;
import com.cloud.merchant.service.IServiceOrderService;
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
public class ServiceOrderServiceImpl extends ServiceImpl<ServiceMapper, ServiceOrder> implements IServiceOrderService {

}
