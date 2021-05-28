package com.cloud.merchant.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.dto.merchant.ActivityAndProjects;
import com.cloud.exception.http.ParameterException;
import com.cloud.merchant.entity.ActivityProject;
import com.cloud.merchant.service.IActivityProjectService;
import com.cloud.utils.json.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
@RequestMapping("/activityProject")
@Slf4j
public class ActivityProjectController {

    private final IActivityProjectService activityProjectService;

    public ActivityProjectController(IActivityProjectService activityProjectService) {
        this.activityProjectService = activityProjectService;
    }

    @PostMapping("/init")
    public JSONResult initActivity(@RequestBody ActivityAndProjects ids){
        Long activityId = ids.getActivityId();
        log.info(activityId.toString());
        List<Long> projectIds = ids.getProjectIds();
        List<ActivityProject> list = new ArrayList<>();
        projectIds.forEach( id -> list.add(new ActivityProject(activityId,id)));
        this.activityProjectService.saveBatch(list);
        return JSONResult.ok("已添加项目到活动中");
    }

    @PostMapping
    public JSONResult addProjectByActivity(@RequestParam Long aid,@RequestParam Long pid){
        ActivityProject activityProject = this.activityProjectService.getOne(new QueryWrapper<ActivityProject>().lambda().eq(ActivityProject::getActivityId, aid)
                .eq(ActivityProject::getProjectId, pid));
        if (activityProject!=null){
            throw new ParameterException(60002);
        }
        this.activityProjectService.save(ActivityProject.builder().activityId(aid).projectId(pid).build());
        return JSONResult.ok("新增项目成功");
    }

    @DeleteMapping
    public JSONResult updateActivityUnderProject(@RequestBody List<Long> ids){
        log.info(ids.toString());
        return JSONResult.ok();
    }
}
