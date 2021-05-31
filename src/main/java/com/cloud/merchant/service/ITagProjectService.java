package com.cloud.merchant.service;

import com.cloud.merchant.entity.TagProject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.vo.merchant.ProjectByTagVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-31
 */
public interface ITagProjectService extends IService<TagProject> {

    /**
     * 根据标签id获取标签下的项目
     * @param id 标签id
     * @return 项目列表
     */
    List<ProjectByTagVO> getProjectByTagId(Long id);
}
