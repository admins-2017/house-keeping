package com.cloud.merchant.service.impl;

import com.cloud.merchant.entity.Customer;
import com.cloud.merchant.mapper.CustomerMapper;
import com.cloud.merchant.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-18
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

}
