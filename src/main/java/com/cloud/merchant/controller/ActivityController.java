package com.cloud.merchant.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.dto.merchant.ActivityDTO;
import com.cloud.merchant.entity.Activity;
import com.cloud.merchant.service.IActivityService;
import com.cloud.utils.json.JSONResult;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-13
 */
@RestController
@RequestMapping("/activity")
@Api("活动控制类")
public class ActivityController {

    private final IActivityService activityService;

    public ActivityController(IActivityService activityService) {
        this.activityService = activityService;
    }

    @PostMapping
    public JSONResult addActivity(@RequestBody ActivityDTO dto){
        activityService.addActivity(dto);
        return JSONResult.ok("新增活动已完成");
    }

    @PutMapping
    public JSONResult updateActivity(@RequestBody ActivityDTO dto){
        activityService.updateActivity(dto);
        return JSONResult.ok("修改活动成功");
    }

    @GetMapping("/{page}/{size}")
    public JSONResult page(@PathVariable Integer page , @PathVariable Integer size){
        return JSONResult.ok();
    }

    @GetMapping("/{aid}")
    public JSONResult getProjectByActivityId(@PathVariable Long aid){
        return JSONResult.ok();
    }
}
