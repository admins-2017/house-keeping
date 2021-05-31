package com.cloud.merchant.mapper;

import com.cloud.merchant.entity.Project;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.vo.merchant.ProjectByCategoryVO;
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
public interface ProjectMapper extends BaseMapper<Project> {

    /**
     * 根据分类id获取项目集合
     * @param ids 分类id列表
     * @return 项目列表
     */
    List<ProjectByCategoryVO> getProjectByRootCategory(@Param("ids") List<Long> ids);

    /**
     * 根据子分类id获取项目结合
     * @param cid 分类id
     * @return 项目列表
     */
    @Select("SELECT\n" +
            "\tproject_id,\n" +
            "\tproject_name,\n" +
            "\tproject_price,\n" +
            "\tproject_discount_price,\n" +
            "\tproject_description,\n" +
            "\tproject_notice,\n" +
            "\tproject_status \n" +
            "FROM\n" +
            "\tmerchant_project \n" +
            "WHERE\n" +
            "\tcategory_id = #{cid}")
    List<ProjectByCategoryVO> getProjectByCategory(@Param("cid") Long cid);
}
