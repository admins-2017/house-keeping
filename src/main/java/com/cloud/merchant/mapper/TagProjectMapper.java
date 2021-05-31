package com.cloud.merchant.mapper;

import com.cloud.merchant.entity.TagProject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.vo.merchant.ProjectByTagVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-31
 */
public interface TagProjectMapper extends BaseMapper<TagProject> {

    /**
     * 根据标签id获取项目
     * @param id 标签id
     * @return 项目列表
     */
    @Select("SELECT mp.project_id,mp.project_name,mp.project_price,mp.project_discount_price,mp.project_description,mp.project_notice,mp.category_id,mp.project_status,mc.category_name FROM merchant_tag_project mtp \n" +
            "LEFT JOIN merchant_project mp \n" +
            "ON mtp.project_id = mp.project_id\n" +
            "JOIN merchant_category mc \n" +
            "ON mp.category_id = mc.category_id\n" +
            "WHERE mtp.tag_id = #{id}")
    List<ProjectByTagVO> getProjectByTagId(@Param("id") Long id);
}
