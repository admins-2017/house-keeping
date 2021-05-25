package com.cloud.merchant.service;

import com.cloud.dto.merchant.ActivityDTO;
import com.cloud.merchant.entity.Activity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-13
 */
public interface IActivityService extends IService<Activity> {

    /**
     * 新增活动并开始计时
     * @param dto 新增实体
     */
    void addActivity(ActivityDTO dto);

    /**
     * 修改活动详情
     * @param dto 活动实体
     */
    void updateActivity(ActivityDTO dto);
}
