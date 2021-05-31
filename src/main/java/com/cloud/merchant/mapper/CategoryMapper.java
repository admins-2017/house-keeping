package com.cloud.merchant.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.merchant.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.vo.merchant.CategoryVO;
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
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 根据分页获取分类
     * @param page 分页对象
     * @return 分页结果
     */
    @Select("SELECT mc.*, sud.user_name as create_user_name,sud2.user_name as update_user_name FROM merchant_category mc\n" +
            "\tLEFT JOIN sys_user_detail sud \n" +
            " ON mc.create_user = sud.user_id\n" +
            " LEFT JOIN sys_user_detail sud2 \n" +
            " ON mc.update_user = sud2.user_id\n" +
            " WHERE mc.is_root = 1 and mc.category_status = 1")
    Page<CategoryVO> getPageByRoot(Page<CategoryVO> page);

    /**
     * 获取所有不是根节点的分类
     * @return 子分类集合
     */
    @Select("SELECT mc.*, sud.user_name as create_user_name,sud2.user_name as update_user_name FROM merchant_category mc\n" +
            "\tLEFT JOIN sys_user_detail sud \n" +
            " ON mc.create_user = sud.user_id\n" +
            " LEFT JOIN sys_user_detail sud2 \n" +
            " ON mc.update_user = sud2.user_id\n" +
            " WHERE mc.is_root = 2 and mc.category_status = 1")
    List<CategoryVO> getCategoryNotRoot();

    /**
     * 根据父分类id获取子分类id集合
     * @param cid 分类id
     * @return 子分类id集合
     */
    @Select("SELECT category_id FROM merchant_category WHERE parent_id = #{cid}")
    List<Long> getIdByRootId(@Param("cid") Long cid);
}
