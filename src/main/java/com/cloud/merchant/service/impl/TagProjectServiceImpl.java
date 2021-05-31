package com.cloud.merchant.service.impl;

import com.cloud.merchant.entity.TagProject;
import com.cloud.merchant.mapper.TagProjectMapper;
import com.cloud.merchant.service.ITagProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.vo.merchant.ProjectByTagVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-31
 */
@Service
public class TagProjectServiceImpl extends ServiceImpl<TagProjectMapper, TagProject> implements ITagProjectService {

    @Override
    public List<ProjectByTagVO> getProjectByTagId(Long id) {
        return this.baseMapper.getProjectByTagId(id);
    }
}
