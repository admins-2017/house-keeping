package com.cloud.merchant.controller;


import com.cloud.dto.merchant.InsertProjectDTO;
import com.cloud.merchant.service.IProjectService;
import com.cloud.utils.json.JSONResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-13
 */
@RestController
@RequestMapping("/project")
public class ProjectController {

    private final IProjectService service;

    public ProjectController(IProjectService service) {
        this.service = service;
    }

    @PostMapping
    public JSONResult addProject(@RequestBody InsertProjectDTO dto){
        return JSONResult.ok();
    }
}
