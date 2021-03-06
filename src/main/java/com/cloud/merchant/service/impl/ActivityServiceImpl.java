package com.cloud.merchant.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.bo.ScheduleJobBO;
import com.cloud.dto.merchant.ActivityDTO;
import com.cloud.exception.http.ParameterException;
import com.cloud.merchant.entity.Activity;
import com.cloud.merchant.mapper.ActivityMapper;
import com.cloud.merchant.service.IActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.sys.entity.ScheduleJob;
import com.cloud.sys.service.IScheduleJobService;
import com.cloud.utils.interchangeable.LocalDateTimeUtil;
import com.cloud.vo.merchant.ActivityAndProjectVO;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-13
 */
@Service
@Slf4j
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements IActivityService {

    private final IScheduleJobService scheduleJobService;

    public ActivityServiceImpl(IScheduleJobService scheduleJobService) {
        this.scheduleJobService = scheduleJobService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addActivity(ActivityDTO dto) {
        Activity activity = new Activity(dto);
        save(activity);
        ScheduleJob job = new ScheduleJob(activity);
        scheduleJobService.save(job);
        ScheduleJobBO task = scheduleJobService.getTaskId(job.getId());
        scheduleJobService.addJob(task);
    }

    @Override
    public void updateActivity(ActivityDTO dto) {
        UpdateWrapper<Activity> wrapper = new UpdateWrapper<>();
        wrapper.lambda()
                .set(!"".equals(dto.getActivityName()),Activity::getActivityName,dto.getActivityName())
                .set(!"".equals(dto.getActivityTheme()),Activity::getActivityTheme,dto.getActivityTheme())
                .set(!"".equals(dto.getActivityStartTime()),Activity::getActivityStartTime,dto.getActivityStartTime())
                .set(!"".equals(dto.getActivityEndTime()),Activity::getActivityEndTime,dto.getActivityEndTime())
                .set(dto.getActivityType()!=0,Activity::getActivityType,dto.getActivityType())
                .set(!"".equals(dto.getActivityFulfill()),Activity::getActivityFulfill,dto.getActivityFulfill())
                .set(!"".equals(dto.getActivityMinus()),Activity::getActivityMinus,dto.getActivityMinus())
                .set(!"".equals(dto.getActivityDiscount()),Activity::getActivityDiscount,dto.getActivityDiscount())
                .set(dto.getActivityStatus()!=0,Activity::getActivityStatus,dto.getActivityStatus())
                .set(!"".equals(dto.getActivityRemark()),Activity::getActivityRemark,dto.getActivityRemark())
                .eq(Activity::getActivityId,dto.getActivityId());
        this.update(wrapper);
        if (!"".equals(dto.getActivityEndTime())){
            LocalDateTime time = LocalDateTimeUtil.parseStringToDateTime(dto.getActivityStartTime(), "yyyy-MM-dd HH:mm:ss");
            ScheduleJobBO job = scheduleJobService.getParamId(dto.getActivityId());
            scheduleJobService.update(new UpdateWrapper<ScheduleJob>().lambda()
                    .set(ScheduleJob::getCronExpression,LocalDateTimeUtil.getDateTimeAsCron(time))
                    .eq(ScheduleJob::getId,job.getId()));
            log.info("job:{}",job);
            try {
                scheduleJobService.operateJob(3,job);

            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Page<ActivityAndProjectVO> getProject(Integer page,Integer size, Long aid) {
        page = (page - 1) * size;
        Page<ActivityAndProjectVO> pages = new Page(page,size);
        return this.baseMapper.getProject(pages,aid);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void offline(Long aid) {
//        将活动状态改为下线
        this.update(new UpdateWrapper<Activity>().lambda()
                .set(Activity::getActivityStatus,2).eq(Activity::getActivityId,aid));
        ScheduleJobBO job = this.scheduleJobService.getParamId(aid);
        try {
//            将任务删除
            this.scheduleJobService.deleteJob(job.getId());
            this.scheduleJobService.operateJob(3,job);
        } catch (SchedulerException e) {
            throw new ParameterException(60001);
        }
    }
}
