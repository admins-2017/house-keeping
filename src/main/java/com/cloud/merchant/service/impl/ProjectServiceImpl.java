package com.cloud.merchant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.merchant.entity.Project;
import com.cloud.merchant.mapper.ProjectMapper;
import com.cloud.merchant.service.IProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.vo.merchant.ProjectByCategoryVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-13
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements IProjectService {

    @Override
    public List<ProjectByCategoryVO> getProjectByRootCategory(List<Long> ids) {
        return this.baseMapper.getProjectByRootCategory(ids);
    }

    @Override
    public List<ProjectByCategoryVO> getProjectByCategory(Long cid) {
        return this.baseMapper.getProjectByCategory(cid);
    }
}
