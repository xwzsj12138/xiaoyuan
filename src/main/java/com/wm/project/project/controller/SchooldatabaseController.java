package com.wm.project.project.controller;

import com.wm.project.project.service.SchooldatabaseService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * (Schooldatabase)表控制层  学校数据库（模拟）
 *
 * @author zyf
 * @since 2022-03-15 16:22:23
 */
@RestController
@RequestMapping("schooldatabase")
public class SchooldatabaseController {
    /**
     * 服务对象
     */
    @Resource
    private SchooldatabaseService schooldatabaseService;

//    @GetMapping("selectByStudentNumber")
//    public Result<Object> selectByStudentNumber(String studentNumber){
//        Schooldatabase schooldatabase = schooldatabaseService.selectByStudentNumber(studentNumber);
//
//    }


}
