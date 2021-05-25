package com.cloud.config.quartz;

import com.cloud.sys.service.IScheduleJobService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 服务器启动时开启执行任务配置类
 * @author 康东伟
 * @date 2021/5/25
 */
@Component
public class JobSchedule implements CommandLineRunner {

    @Resource
    private IScheduleJobService jobService;

    /**
     * 任务调度开始
     * @param strings 集合
     */
    @Override
    public void run(String... strings) {
        jobService.timingTask();
    }
}