package com.cloud.sys.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cloud.config.redis.RedisOperator;
import com.cloud.config.security.entity.SecurityUser;
import com.cloud.dto.sys.UserWithDeatilDTO;
import com.cloud.sys.entity.User;
import com.cloud.sys.service.IUserService;
import com.cloud.utils.json.JSONResult;
import com.cloud.utils.security.SecurityUntil;
import com.cloud.vo.sys.UserWithDetailVO;
import com.wf.captcha.ArithmeticCaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-11
 */
@RestController
@RequestMapping("/user")
@Api(value="系统用户控制类",tags = "系统用户控制类")
public class UserController {
    private final IUserService userService;
    private final RedisOperator redisOperator;

    public UserController(RedisOperator redisOperator,IUserService userService) {
        this.redisOperator = redisOperator;
        this.userService = userService;
    }

    @ApiOperation("获取验证码")
    @GetMapping(value = "/code")
    public ResponseEntity<Object> getCode(){
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(111, 36);
        // 几位数运算，默认是两位
        captcha.setLen(2);
        // 获取运算的结果
        String result = captcha.text();
        String uuid = "loginCode:"+ UUID.randomUUID().toString();

        System.out.println("result:"+result);
        System.out.println("uuid:"+uuid);

        // 保存
        redisOperator.set(uuid, result,120);
        Map<String,Object> imgResult = new HashMap<String,Object>(2){{
            put("status",200);
            put("img", captcha.toBase64());
            put("uuid", uuid);
        }};
        return ResponseEntity.ok(imgResult);
    }

    @PostMapping
    public JSONResult addUserAndDetail(UserWithDeatilDTO dto){
        userService.addUser(dto);
        return JSONResult.ok("新建用户成功");
    }

    @DeleteMapping("/{id}")
    public JSONResult removeUser(@PathVariable Long id){
        userService.update(new UpdateWrapper<User>().lambda()
                .set(User::getUserStatus,"PROHIBIT").eq(User::getUserId,id));
        return JSONResult.ok("注销用户成功");
    }

    @PutMapping
    public JSONResult updateUser(UserWithDeatilDTO dto){
        userService.updateUser(dto);
        return JSONResult.ok("修改用户信息完成");
    }

    @GetMapping("/{page}/{size}")
    public JSONResult page(@PathVariable Integer page , @PathVariable Integer size){
        IPage<UserWithDetailVO> vos =  userService.getPage(page,size);
        return JSONResult.ok(vos);
    }



    @GetMapping("/info/admin")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public JSONResult admin(){
        return JSONResult.ok(SecurityUntil.getUserInfo());
    }

    @GetMapping("/info/user")
    @PreAuthorize("hasAnyRole('user','SUPER_ADMIN')")
    public JSONResult user(){
        return JSONResult.ok(new SecurityUser());
    }

    /**
     * 必须同时拥有SUPER_ADMIN和admin的话
     * @return
     */
    @GetMapping("/helloUser")
    @PreAuthorize("hasRole('SUPER_ADMIN') AND hasRole('user')")
    public String helloUser() {
        return "hello,user";
    }

}
