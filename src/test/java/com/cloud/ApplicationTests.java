package com.cloud;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.bo.ScheduleJobBO;
import com.cloud.config.redis.RedisOperator;
import com.cloud.sys.entity.ScheduleJob;
import com.cloud.sys.entity.User;
import com.cloud.sys.mapper.UserMapper;
import com.cloud.sys.service.IRoleService;
import com.cloud.sys.service.IScheduleJobService;
import com.cloud.sys.service.IUserService;
import com.cloud.utils.interchangeable.LocalDateTimeUtil;
import com.cloud.utils.interchangeable.ParseMenuTreeUtil;
import com.cloud.vo.sys.MenuVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@Slf4j
class ApplicationTests {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private RedisOperator redisOperator;

    @Autowired
    private IScheduleJobService scheduleJobService;

    @Test
    public void testTreeMenu(){
        List<MenuVO> vos = roleService.getMenuByRoleId(1l);
        List<MenuVO> menuVOS = ParseMenuTreeUtil.parseMenuTree(vos);
        menuVOS.forEach(System.out::println);
    }

    @Test
    public void testRedis(){
        redisOperator.set("frist","redis");
    }
    

    @Test
    void contextLoads() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println(encode);
    }

    /**
     * 测试添加
     */
    @Test
    public void testInsertUser(){
        User user = User.builder().loginName("k-0021").password("123456").registeredTime(LocalDateTime.now()).build();
        userService.save(user);
    }

    /**
     * 批量添加
     */
    @Test
    public void testBatchInsert(){
        List<User> userList = new ArrayList(10);
        for (int i = 0; i <10 ; i++) {
            User user = User.builder().loginName("k-001"+i).password("123456").registeredTime(LocalDateTime.now()).build();
            userList.add(user);
        }
        userService.saveBatch(userList);
    }

    /**
     * 根据实体id修改
     */
    @Test
    public void testUpdateUser(){
        User user = User.builder().password("654321").userId(1l).build();
        userService.updateById(user);
    }

    /**
     * wrapper lambda 方式修改
     */
    @Test
    public void testUpdate(){
        userService.update(new UpdateWrapper<User>().lambda().eq(User::getUserId,1).set(User::getUserStatus,"PROHIBIT"));
    }

    /**
     * 根据id删除
     */
    @Test
    public void testDeleteUser(){
        userService.removeById(11);
    }

    /**
     * 条件删除
     */
    @Test
    public void testDelete(){
        userService.remove(new QueryWrapper<User>().lambda().between(User::getUserId,8,10));
    }

    /**
     * 根据id批量删除
     */
    @Test
    public void testBatchDelete(){
        List<Integer> ids = new ArrayList<>();
        ids.add(5);
        ids.add(6);
        ids.add(7);
        userService.removeByIds(ids);
    }

    /**
     * 查询测试
     * 条件构造器 请查看官方文档 https://mp.baomidou.com/guide/wrapper.html
     */
    @Test
    public void testSelect(){
//      根据 id 查询
        User byId = userService.getById(1);
        System.out.println(byId);
//      根据条件获取一条记录
//        User one = userService.getOne(new QueryWrapper<User>().eq("login_name", "k-0010"));
//        System.out.println(one);
//      获取符合条件的记录
//        List<User> list = userService.list(new QueryWrapper<User>().lambda().eq(User::getUserStatus, "NORMAL"));
//        list.forEach(System.out::println);
//      分页查询
//        int current = 2;
//        int size = 2;
//        Page<User> page = new Page<>(current,size);
//        Page<User> userPage = userService.page(page);
//        System.out.println(userPage);
    }

    @Test
    public void testLocal(){
        LocalDateTime now = LocalDateTime.now();
        String format  = "yyyy-MM-dd HH:mm:ss";
        String dateTimeAsString = LocalDateTimeUtil.getDateTimeAsString(now, format);
        System.out.println(dateTimeAsString);
    }

    @Test
    public void test_getCron(){
        String format  = "yyyy-MM-dd HH:mm:ss";
        String dateTime = "2021-05-25 11:30:37";
        LocalDateTime time = LocalDateTimeUtil.parseStringToDateTime(dateTime, format);
        String dateTimeAsCron = LocalDateTimeUtil.getDateTimeAsCron(time);
        System.out.println(dateTimeAsCron);
    }


}
