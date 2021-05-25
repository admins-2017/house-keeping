package com.cloud.jobs;

import lombok.extern.slf4j.Slf4j;
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

//    private final IStatisticsService statisticsService;
//    private final IDayService dayService;

    /**
     * 默认执行方法
     */
    public void execute(){
        log.info("执行了默认的方法");
    }

    /**
     * 默认执行方法
     */
//    public void test(User user){
//        log.info("执行test："+user.toString());
//    }

    /**
     * 默认执行方法
     */
    public void getMailUrl(String url){
        log.info("执行getMailUrl："+url);
    }

    /**
     * 默认执行方法
     */
    public void testList(List<String> list){
        log.info("执行testList");
        list.stream().forEach(System.out::println);
    }

//    public void testObjectList(List<User> list){
//        for (User user : list) {
//            System.out.println(user);
//        }
//    }

    /**
     * 定时统计
     */
//    public void timingStatistics(){
//        statisticsService.insertStatistics();
//    }

    /**
     * 每日统计进销次数
     */
//    public void countByDay(){
//        dayService.addCountByDay();
//    }
//
//    public TestJob(IStatisticsService statisticsService,IDayService dayService) {
//        this.statisticsService = statisticsService;
//        this.dayService = dayService;
//    }
}

