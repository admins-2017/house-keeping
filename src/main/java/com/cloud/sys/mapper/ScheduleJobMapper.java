package com.cloud.sys.mapper;

import com.cloud.bo.ScheduleJobBO;
import com.cloud.sys.entity.ScheduleJob;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.vo.sys.ScheduleJobVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-25
 */
public interface ScheduleJobMapper extends BaseMapper<ScheduleJob> {

    /**
     * 服务器启动获取所有执行任务
     * @return 任务集合
     */
    @Select("select a.*,b.bean_name,b.method_name,b.method_arg_type from sys_schedule_job a\n" +
            "   LEFT JOIN sys_schedule_detail b on a.detail_id = b.id\n" +
            "   where a.status = 1 and a.delete_flag = 0")
    List<ScheduleJobBO> getTimingTasks();

    /**
     * 根据id获取任务
     * @param id
     * @return
     */
    @Select("select a.*,b.bean_name,b.method_name,b.method_arg_type from sys_schedule_job a LEFT JOIN sys_schedule_detail b on a.detail_id = b.id where a.id = #{id}")
    ScheduleJobVO getTaskId(@Param("id") Integer id);


}
