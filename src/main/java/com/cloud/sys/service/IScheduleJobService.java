package com.cloud.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cloud.bo.ScheduleJobBO;
import com.cloud.dto.sys.ScheduleJobDTO;
import com.cloud.sys.entity.ScheduleJob;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.vo.sys.ScheduleJobVO;
import org.quartz.SchedulerException;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-25
 */
public interface IScheduleJobService extends IService<ScheduleJob> {

    /**
     * 服务器启动执行定时任务
     */
    void timingTask();

    /**
     * 新增定时任务
     * @param job 任务
     */
    void addJob(ScheduleJobBO job);

    /**
     * 操作定时任务
     * @param jobStatus 操作枚举
     * @param job 任务
     * @throws SchedulerException 任务异常
     */
    void operateJob(Integer jobStatus, ScheduleJobBO job) throws SchedulerException;

    /**
     * 启动所有任务
     * @throws SchedulerException 任务异常
     */
    void startAllJob() throws SchedulerException;

    /**
     * 暂停所有任务
     * @throws SchedulerException 任务异常
     */
    void pauseAllJob() throws SchedulerException;

    /**
     * 获取所有任务
     * @return 任务集合
     */
    List<ScheduleJobVO> getAllJob() ;

    /**
     * 根据任务id获取任务
     * @param id 任务id
     * @return 任务详情
     */
    ScheduleJobBO getTaskId(Long id);

    /**
     * 根据参数id获取任务
     * @param id 任务id
     * @return 任务详情
     */
    ScheduleJobBO getParamId(Long id);

    /**
     * 删除任务
     * @param id 任务id
     */
    void deleteJob(Integer id);
}
