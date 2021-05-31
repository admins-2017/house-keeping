package com.cloud.merchant.service;

import com.cloud.merchant.entity.Tag;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.vo.merchant.ProjectByTagVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-13
 */
public interface ITagService extends IService<Tag> {

    /**
     * 删除标签
     * @param id 标签id
     */
    void deleteTag(Long id);

    /**
     * 根据标签获取项目
     * @param id 标签id
     * @return 标签下的项目
     */
    List<ProjectByTagVO> getProject(Long id);
}
