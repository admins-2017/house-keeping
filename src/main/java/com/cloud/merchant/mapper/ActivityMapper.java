package com.cloud.merchant.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.merchant.entity.Activity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.vo.merchant.ActivityAndProjectVO;
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
public interface ActivityMapper extends BaseMapper<Activity> {

    /**
     * 根据id获取活动下的项目
     *
     * @param pages
     * @param aid 活动id
     * @return 项目列表
     */
    @Select("SELECT DISTINCT mp.project_id,mp.project_name,mp.project_price,mp.project_discount_price,mp.project_description,project_status,mpg.img_url FROM merchant_activity_project ap \n" +
            "\tLEFT JOIN merchant_project mp \n" +
            "\tON ap.project_id = mp.project_id \n" +
            "\tLEFT JOIN merchant_project_img mpg\n" +
            "\tON mp.project_id = mpg.project_id\n" +
            "where ap.activity_id = #{aid} AND mpg.img_status = 1")
    Page<ActivityAndProjectVO> getProject(Page<ActivityAndProjectVO> pages, @Param("aid") Long aid);
}
