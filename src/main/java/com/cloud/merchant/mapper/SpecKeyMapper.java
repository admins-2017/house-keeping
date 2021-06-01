package com.cloud.merchant.mapper;

import com.cloud.merchant.entity.SpecKey;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.vo.merchant.SpecKeyVO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-13
 */
public interface SpecKeyMapper extends BaseMapper<SpecKey> {

    /**
     * 获取所有规格信息
     * @return 规格列表
     */
    List<SpecKeyVO> getAllKeyAndValue();
}
