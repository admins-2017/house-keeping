package com.cloud.config.quartz;

import com.cloud.bo.ScheduleJobBO;
import com.cloud.utils.json.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.lang.reflect.Method;

/**
 * @author 康东伟
 * @date 2021/5/25
 */
@Slf4j
public class QuartzFactory implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext)  {

        //获取调度数据
        ScheduleJobBO scheduleJob = (ScheduleJobBO) jobExecutionContext.getMergedJobDataMap().get("scheduleJob");
        //获取对应的Bean
        Object object = SpringUtil.getBean(scheduleJob.getBeanName());
        try {
            //利用反射执行对应方法 判断方法是否有参数
            if (scheduleJob.getMethodArgType() != null && !scheduleJob.getMethodArgType().equals("")) {
                //判断参数类型为string
                if(scheduleJob.getMethodArgType().equals("java.lang.String")){
                    //根据方法名及参数类型获取方法实例
                    Method method = object.getClass().getMethod(scheduleJob.getMethodName(), Class.forName(scheduleJob.getMethodArgType()));
                    //执行方法 并传入参数
                    method.invoke(object, scheduleJob.getMethodParams());
                }else if(scheduleJob.getMethodArgType().equals("java.util.List,com.giantlizardcloud.sys.entity.User")){
                    //将字段的类型分割
                    String[] split = scheduleJob.getMethodArgType().split(",");
                    Method method = object.getClass().getMethod(scheduleJob.getMethodName(), Class.forName(split[0]));
                    Object o = JsonUtils.jsonToList(scheduleJob.getMethodParams(), Class.forName(split[1]));
                    method.invoke(object, o);
                }else{
                    Method method = object.getClass().getMethod(scheduleJob.getMethodName(), Class.forName(scheduleJob.getMethodArgType()));
                    Object o = JsonUtils.jsonToPojo(scheduleJob.getMethodParams(), Class.forName(scheduleJob.getMethodArgType()));
                    method.invoke(object, o);
                }
            } else {
                Method method = object.getClass().getMethod(scheduleJob.getMethodName());
                method.invoke(object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
