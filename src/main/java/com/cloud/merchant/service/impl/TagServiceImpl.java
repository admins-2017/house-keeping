package com.cloud.merchant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cloud.merchant.entity.Tag;
import com.cloud.merchant.entity.TagProject;
import com.cloud.merchant.mapper.TagMapper;
import com.cloud.merchant.service.ITagProjectService;
import com.cloud.merchant.service.ITagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.vo.merchant.ProjectByTagVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

    private final ITagProjectService tagProjectService;

    public TagServiceImpl(ITagProjectService tagProjectService) {
        this.tagProjectService = tagProjectService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTag(Long id) {
        this.update(new UpdateWrapper<Tag>().lambda().set(Tag::getTagStatus,2).eq(Tag::getTagId,id));
        this.tagProjectService.remove(new QueryWrapper<TagProject>().lambda()
                .eq(TagProject::getTagId,id));
    }

    @Override
    public List<ProjectByTagVO> getProject(Long id) {
        return this.tagProjectService.getProjectByTagId(id);
    }

}
