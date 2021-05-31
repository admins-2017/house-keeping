package com.cloud.merchant.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.merchant.entity.Category;
import com.cloud.merchant.service.ICategoryService;
import com.cloud.vo.merchant.CategoryVO;
import com.cloud.vo.merchant.ProjectByCategoryVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 康东伟
 * @date 2021/5/31
 */
@SpringBootTest
@Slf4j
class CategoryServiceImplTest {

    @Autowired
    private ICategoryService categoryService;

    @Test
    public void testGetPage(){
        Page<CategoryVO> page = categoryService.getPage(2, 10);
        List<CategoryVO> records = page.getRecords();
        records.forEach(
                s -> {
                    log.info(s.toString());
                }
        );
    }

    @Test
    public void testAdd(){
        List<Category> categories = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            categories.add(Category.builder().categoryName("家纺").categoryDescription("家纺").categoryImg("http://kangdongwei.cn/0cf23561c21f4e148bf047213e26667a.jpg")
                    .categoryLevel(2).isRoot(2).parentId(34L).createUser(1L).createTime(LocalDateTime.now())
                    .build());
        }
        categoryService.saveBatch(categories);
    }

    @Test
    public void testGetProject(){
        List<ProjectByCategoryVO> project = categoryService.getProject(1L, 1);
        project.forEach(System.out::println);
    }
}