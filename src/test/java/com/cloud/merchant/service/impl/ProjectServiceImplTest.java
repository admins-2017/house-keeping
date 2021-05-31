package com.cloud.merchant.service.impl;

import com.cloud.merchant.service.IProjectService;
import com.cloud.vo.merchant.ProjectByCategoryVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 康东伟
 * @date 2021/5/31
 */
@SpringBootTest
@Slf4j
class ProjectServiceImplTest {

    @Autowired
    private IProjectService projectService;

    @Test
    public void test(){
        List<Long> ids = new ArrayList<>();
        ids.add(2L);
        ids.add(3L);
        ids.add(4L);
        List<ProjectByCategoryVO> vos = projectService.getProjectByRootCategory(ids);
        vos.forEach(System.out::println);
    }
}