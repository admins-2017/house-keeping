package com.cloud.merchant.service;

import com.cloud.merchant.entity.SpecKey;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.vo.merchant.SpecKeyVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-13
 */
public interface ISpecKeyService extends IService<SpecKey> {

    /**
     * 获取所有规格信息
     * @return 规格列表
     */
    List<SpecKeyVO> getAllKeyAndValue();
}
