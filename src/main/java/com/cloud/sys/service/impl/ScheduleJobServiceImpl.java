package com.cloud.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.bo.ScheduleJobBO;
import com.cloud.config.quartz.QuartzFactory;
import com.cloud.exception.http.ParameterException;
import com.cloud.sys.entity.ScheduleJob;
import com.cloud.sys.mapper.ScheduleJobMapper;
import com.cloud.sys.service.IScheduleJobService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.vo.sys.ScheduleJobVO;
import org.quartz.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author 康东伟
 * @since 2021-05-25
 */
@Service
public class ScheduleJobServiceImpl extends ServiceImpl<ScheduleJobMapper, ScheduleJob> implements IScheduleJobService {

    private final Scheduler scheduler;

    public ScheduleJobServiceImpl(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void timingTask() {
        List<ScheduleJobBO> jobs = this.baseMapper.getTimingTasks();
        if (jobs != null) {
            jobs.forEach(this::addJob);
        }
    }

    @Override
    public void addJob(ScheduleJobBO job) {
        try {
            //创建触发器
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName())
                    .withSchedule(CronScheduleBuilder.cronSchedule(job.getCronExpression()))
                    .startNow()
                    .build();
            //创建任务
            JobDetail jobDetail = JobBuilder.newJob(QuartzFactory.class)
                    .withIdentity(job.getJobName())
                    .build();
            //传入调度的数据，在QuartzFactory中需要使用
            jobDetail.getJobDataMap().put("scheduleJob", job);
            //调度作业
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void operateJob(Integer jobStatus, ScheduleJobBO job) throws SchedulerException {
        JobKey jobKey = new JobKey(job.getJobName());
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (null==jobDetail){
            log.error("任务为空");
            addJob(job);
        }
        switch (jobStatus){
            case 1:
                //恢复任务
                scheduler.resumeJob(jobKey);
                break;
            case 2:
                //暂停任务
                scheduler.pauseJob(jobKey);
                break;
            case 3:
                //删除任务
                scheduler.deleteJob(jobKey);
                break;
            default:
                throw new ParameterException(40020);
        }
    }

    @Override
    public void startAllJob() throws SchedulerException {
        scheduler.start();
    }

    @Override
    public void pauseAllJob() throws SchedulerException {
        scheduler.standby();
    }

    @Override
    public List<ScheduleJobVO> getAllJob() {
        return null;
    }

    @Override
    public ScheduleJobBO getTaskId(Long id) {
        return this.baseMapper.getTaskId(id);
    }

    @Override
    public ScheduleJobBO getParamId(Long id) {
        return this.baseMapper.getParamId(id);
    }


}
