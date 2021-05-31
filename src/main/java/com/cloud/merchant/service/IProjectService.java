package com.cloud.merchant.service;

import com.cloud.merchant.entity.Project;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.vo.merchant.ProjectByCategoryVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-13
 */
public interface IProjectService extends IService<Project> {

    /**
     * 根据多分类获取项目
     * @param ids 分类id集合
     * @return 项目列表
     */
    List<ProjectByCategoryVO> getProjectByRootCategory(List<Long> ids);

    /**
     * 根据子分类id获取项目
     * @param cid 分类id
     * @return 项目列表
     */
    List<ProjectByCategoryVO> getProjectByCategory(Long cid);
}
