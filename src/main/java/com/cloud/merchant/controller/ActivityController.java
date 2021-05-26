package com.cloud.merchant.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.dto.merchant.ActivityDTO;
import com.cloud.merchant.entity.Activity;
import com.cloud.merchant.service.IActivityService;
import com.cloud.utils.json.JSONResult;
import com.cloud.vo.merchant.ActivityAndProjectVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
@Slf4j
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
    public JSONResult page(@PathVariable Integer page , @PathVariable Integer size,@RequestParam(required = false,defaultValue = "0") Integer status
            ,@RequestParam(required = false,defaultValue = "0") Integer type){
        Page<Activity> paging = new Page<>(page,size);
        Page<Activity> activityPage = activityService.page(paging, new QueryWrapper<Activity>().lambda().eq(type != 0, Activity::getActivityType, type)
                .eq(status != 0, Activity::getActivityStatus, status));
        return JSONResult.ok(activityPage);
    }

    @GetMapping("/{page}/{size}/{aid}")
    public JSONResult getProjectByActivityId(@PathVariable Integer page , @PathVariable Integer size, @PathVariable Long aid){
        Page<ActivityAndProjectVO> vos = activityService.getProject(page,size,aid);
        return JSONResult.ok(vos);
    }
}
