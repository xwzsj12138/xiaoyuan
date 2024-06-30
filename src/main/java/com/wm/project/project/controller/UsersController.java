package com.wm.project.project.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jfinal.json.Json;
import com.wm.project.project.config.AnnoDemo2Methred;
import com.wm.project.project.entity.Users;
import com.wm.project.project.service.UsersService;
import com.wm.project.project.util.CommonUtil;
import com.wm.project.project.util.JwtUtil;
import com.wm.project.project.util.PageResult;
import com.wm.project.project.util.Result;
import com.wm.project.project.util.page.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Users)表控制层
 *
 * @author zyf
 * @since 2022-03-15 10:05:16
 */
@RestController
@CrossOrigin
@RequestMapping("/users")
public class UsersController {
    /**
     * 服务对象
     */
    @Resource
    private UsersService usersService;

    /**
     * 注册
     *
     * @param users
     * @return
     */
    @PostMapping("loginInsert")
    public Result<Object> loginInsert(@RequestBody Users users) {
        int insert = usersService.insert(users);
        if (insert == 1) {
            return CommonUtil.successResult("操作成功");
        } else {
            return CommonUtil.errorResult("操作失败");
        }
    }

    /**
     * (普通)登录
     *
     * @param users
     * @return
     */
    @PostMapping("login")
    public Result<Object> login(@RequestBody Users users) {
        Users flag = usersService.login(users);
        if (flag != null) {
            return CommonUtil.successResult(flag);
        } else {
            return CommonUtil.errorResult("用户名或密码错误");
        }
    }



    /**
     * 分页查询
     * @param models
     * @return
     */
    @PostMapping("selectPageByUsers")
    public PageResult selectPageByUsers(@RequestBody Map<String, Object> models) {
        PageRequest pageRequest = JSON.parseObject(JSON.toJSONString(models.get("pageRequest")), PageRequest.class);
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<Users> users = usersService.selectPageByUsers(models);
        return new PageResult(new PageInfo<>(users));
    }

    /**
     * 注销字段
     *
     * @param
     * @return
     */

    @GetMapping("IsCancellation")
    public Result<Object> IsCancellation(String userId) {

        int i = usersService.IsCancellation(userId);
        if(i>0){
            return CommonUtil.successResult();
        }else {
            return  CommonUtil.errorResult("注销失败");
        }
    }

    /**
     * 使用jwtToken登录
     * @param users
     * @return
     */
    @PostMapping("loginByJwt")
    public Result<Object> loginByJwt(@RequestBody String users){
        JSONObject jsonObject = JSON.parseObject(users);
        String s = jsonObject.toString();
        //        Users login = usersService.login(users);
//        //进行token验证
//        if(login!=null){
//            String token = JwtUtil.sign(login.getLoginName(),login.getPasswordMd5());
//            if(token!=null){
//                login.setToken(token);
//                return CommonUtil.successResult(login);
//            }
//        }
        return  CommonUtil.errorResult();
    }

    /**
     * 测试（获取到请求头）
     * @param token
     * @param users
     * @return
     */
    @PostMapping("demo2")
    public Result<Object> demo2(@RequestHeader("access_token") String token,@RequestBody Users users){
        System.out.println(token+"heade");
        System.out.println(users+"users");
        String username = JwtUtil.getUsername(token);
        System.out.println(username+"username");
        System.out.println(username+"username");
        return CommonUtil.successResult();
    }
    @GetMapping("test")
    @AnnoDemo2Methred(id = "id",name = "test")
    public Result<Object> test(String id){
        List<Users> users = usersService.selectPageByUsers(null);
        return CommonUtil.successResult(users);
    }

//    @GetMapping ("test")
//    public String demo(String ok){
//        System.out.println(ok);
//        return "okook";
//    }
//
//    @PostMapping("test2")
//    public Users test2(@RequestBody Users users){
//        System.out.println(users+"test2!!!!!!!!!!!!!!!");
//        return  users;
//    }

    /**
     * 微信接口查询数据，并做出处理
     * @param userId
     * @return
     */
    @GetMapping("WxSelectByUsersId")
    public Result<Object> WxSelectByUsersId(String userId){
      Users users= usersService.WxSelectByUsersId(userId);
       if(users!=null){
           return CommonUtil.successResult(users);
       }else {
           return CommonUtil.errorResult();
       }
    }
    @GetMapping("Test1")
    public String Test1(String userId){
        System.out.println("userId222222+"+userId);
       return "testDemo1:"+userId;
    }
    @GetMapping("Test12")
    public String Test12(String userId){
        System.out.println("userId+"+userId);
        return "testDemo1:"+userId;
    }
}
