package com.cloud.merchant.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cloud.dto.merchant.CategoryDTO;
import com.cloud.dto.merchant.UpdateCategoryDTO;
import com.cloud.merchant.entity.Category;
import com.cloud.merchant.entity.CouponCategory;
import com.cloud.merchant.entity.Project;
import com.cloud.merchant.service.ICategoryService;
import com.cloud.merchant.service.ICouponCategoryService;
import com.cloud.merchant.service.IProjectService;
import com.cloud.utils.json.JSONResult;
import com.cloud.utils.security.SecurityUntil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-13
 */
@RestController
@RequestMapping("/category")
@Api(value="分类控制类",tags = "分类控制类")
@Slf4j
public class CategoryController {

    private final ICategoryService categoryService;
    private final IProjectService projectService;
    private final ICouponCategoryService couponCategoryService;

    public CategoryController(ICategoryService categoryService,IProjectService projectService,ICouponCategoryService couponCategoryService) {
        this.categoryService = categoryService;
        this.projectService = projectService;
        this.couponCategoryService = couponCategoryService;
    }

    @PostMapping
    public JSONResult addCategory(@RequestBody CategoryDTO dto){
        log.info(dto.toString());
        Category category = new Category(dto);
        categoryService.save(category);
        return JSONResult.ok("新增分类成功");
    }

    @DeleteMapping("/{cid}")
    public JSONResult delCategory(@PathVariable Long cid){
        int count = projectService.count(new QueryWrapper<Project>().lambda().eq(Project::getCategoryId, cid));
        if (count > 0){
            return JSONResult.errorException("分类下还存在项目，请先移出项目");
        }
        int couponCount = couponCategoryService.count(new QueryWrapper<CouponCategory>().lambda().eq(CouponCategory::getCategoryId, cid));
        if (couponCount > 0){
            return JSONResult.errorException("当前分类正被优惠券使用，删除失败");
        }
        categoryService.update(new UpdateWrapper<Category>().lambda()
        .set(Category::getCategoryStatus,2).eq(Category::getCategoryId,cid));
        return JSONResult.ok("删除分类成功");
    }

    @PutMapping
    public JSONResult updCategory(@RequestBody UpdateCategoryDTO dto){
        log.info(dto.toString());
        categoryService.update(new UpdateWrapper<Category>().lambda()
                .set(!"".equals(dto.getCategoryName()),Category::getCategoryName,dto.getCategoryName())
                .set(!"".equals(dto.getCategoryDescription()),Category::getCategoryDescription,dto.getCategoryDescription())
                .set(!"".equals(dto.getCategoryImg()),Category::getCategoryImg,dto.getCategoryImg())
                .set(Category::getUpdateTime,LocalDateTime.now())
                .set(Category::getUpdateUser, SecurityUntil.getUserId())
                .eq(Category::getCategoryId,dto.getCategoryId())
        );
        return JSONResult.ok("修改分类详情成功");
    }

    @GetMapping("/{page}/{size}")
    public JSONResult getCategoryByPage(@PathVariable Integer page,@PathVariable Integer size){
        return JSONResult.ok(page+size);
    }

    @GetMapping("/{cid}")
    public JSONResult getProjectByCategory(@PathVariable Long cid){
        return JSONResult.ok(cid);
    }
}
