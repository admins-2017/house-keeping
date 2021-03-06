package com.cloud.merchant.service.impl;

import com.cloud.merchant.entity.SpecKey;
import com.cloud.merchant.mapper.SpecKeyMapper;
import com.cloud.merchant.service.ISpecKeyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.vo.merchant.SpecKeyVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-13
 */
@Service
public class SpecKeyServiceImpl extends ServiceImpl<SpecKeyMapper, SpecKey> implements ISpecKeyService {

    @Override
    public List<SpecKeyVO> getAllKeyAndValue() {
        return this.baseMapper.getAllKeyAndValue();
    }
}
