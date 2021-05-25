package com.cloud.config.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Scheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;


/**
 * @author 康东伟
 * @date 2021/5/25
 */

@Configuration
@Slf4j
public class QuartzConfig {

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        //覆盖已存在的任务
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        //延时60秒启动定时任务，避免系统未完全启动却开始执行定时任务的情况
        schedulerFactoryBean.setStartupDelay(60);
        log.info("执行任务启动");
        return schedulerFactoryBean;
    }

    /**
     * 创建schedule
     */
    @Bean(name = "scheduler")
    public Scheduler scheduler() {
        return schedulerFactoryBean().getScheduler();
    }
}
