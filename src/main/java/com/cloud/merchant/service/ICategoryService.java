package com.cloud.merchant.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.merchant.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.vo.merchant.CategoryVO;
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
public interface ICategoryService extends IService<Category> {

    /**
     * 根据分页获取分类详情
     * @param page 页码
     * @param size 条数
     * @return 分类集合
     */
    Page<CategoryVO> getPage(Integer page, Integer size);

    /**
     * 根据分类id获取所属分类的项目
     * @param cid 分类id
     * @param root 是否为根目录
     * @return 项目结果集合
     */
    List<ProjectByCategoryVO> getProject(Long cid, Integer root);
}
