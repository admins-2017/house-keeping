package com.cloud.jobs;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cloud.merchant.entity.Activity;
import com.cloud.merchant.service.IActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 康东伟
 * @date 2021/5/25
 */
@Component("testJob")
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class TestJob {

    @Autowired
    private IActivityService activityService;

    /**
     * 默认执行方法
     */
    public void execute(){
        log.info("执行了默认的方法");
    }

    /**
     * 默认执行方法
     */
    public void stopActivity(Long aid){
        log.info("执行getMailUrl："+aid);
        activityService.update(new UpdateWrapper<Activity>()
            .lambda().set(Activity::getActivityStatus,3)
            .eq(Activity::getActivityId,aid)
        );
    }

    /**
     * 默认执行方法
     */
    public void testList(List<String> list){
        log.info("执行testList");
        list.stream().forEach(System.out::println);
    }

}

