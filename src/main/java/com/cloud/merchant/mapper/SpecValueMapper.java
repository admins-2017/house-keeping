package com.cloud.merchant.mapper;

import com.cloud.merchant.entity.SpecValue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.vo.merchant.SpecValueVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-13
 */
public interface SpecValueMapper extends BaseMapper<SpecValue> {

    /**
     * 根据规格名获取所有规格值
     * @param keyId  规格名id
     * @return 规格值列表
     */
    @Select("SELECT * FROM merchant_spec_value WHERE key_id = #{key_id}")
    List<SpecValueVO> getAllByKeyId(@Param("key_id")Long keyId);
}
