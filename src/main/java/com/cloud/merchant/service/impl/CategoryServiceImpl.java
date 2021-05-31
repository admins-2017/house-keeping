package com.cloud.merchant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.merchant.entity.Category;
import com.cloud.merchant.mapper.CategoryMapper;
import com.cloud.merchant.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.merchant.service.IProjectService;
import com.cloud.utils.interchangeable.ParseCategoryUtil;
import com.cloud.utils.interchangeable.ParseMenuTreeUtil;
import com.cloud.vo.merchant.CategoryVO;
import com.cloud.vo.merchant.ProjectByCategoryVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
@Slf4j
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    private final IProjectService projectService;

    public CategoryServiceImpl(IProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public Page<CategoryVO> getPage(Integer page, Integer size) {
        Page<CategoryVO> vo = this.baseMapper.getPageByRoot(new Page<>(page, size));
        List<CategoryVO> children =  this.baseMapper.getCategoryNotRoot();
        Page<CategoryVO> categoryVOPage = ParseCategoryUtil.parseCategoryTree(vo, children);
        return categoryVOPage;
    }

    @Override
    public List<ProjectByCategoryVO> getProject(Long cid, Integer root) {
        if (root == 1){
            List<Long> ids = this.baseMapper.getIdByRootId(cid);
            List<ProjectByCategoryVO> vos = this.projectService.getProjectByRootCategory(ids);
            return vos ;
        }
        return this.projectService.getProjectByCategory(cid);
    }

}
