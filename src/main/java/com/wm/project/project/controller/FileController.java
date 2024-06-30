package com.wm.project.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.wm.project.project.service.FileService;
import com.wm.project.project.service.LogService;
import com.wm.project.project.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zyf
 * @since 2022/3/14 10:51
 */

@RestController
@Scope("prototype")
@RequestMapping("/file")
public class FileController {
//    @Autowired
//    private LogService logService;
    @Resource
    private FileService fileService;


//    /**
//     * 下载文件接口
//     *
//     * @param name
//     * @param response
//     * @throws Exception
//     */
//    @GetMapping(value = "/download/{name}")
//    public void logDownload(@PathVariable String name, HttpServletResponse response) throws Exception {
//        logService.logDownload(name, response);
//
//    }
//
//    /**
//     * 上传文件接口
//     * @param file
//     * @return
//     * @throws Exception
//     */
//    @PostMapping(value = "/upload")
//    public Result<Object> logUpload(@RequestParam("file") MultipartFile file) throws Exception {
//        return  logService.logUpload(file);
//    }

    /**
     * 浏览器上传文件
     * MultipartFile 自动封装上传过来的文件
     * @param files 一个或多个文件
     * @return Result
     */
    @PostMapping("upload")
    public Result<Object> upload(@RequestPart("file") MultipartFile[] files) throws IOException {
        return this.fileService.upload(files);
    }

}
