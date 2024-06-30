package com.wm.project.project.service.impl;

import com.wm.project.project.service.FileService;
import com.wm.project.project.util.CommonUtil;
import com.wm.project.project.util.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author zyf
 * @since 2022/3/14 11:21
 */
@Service
public class FileServiceImp implements FileService {
    @Value("${file.filePath}")
    private String filePath;
    @Value("${file.uploadFolder}")
    private String uploadFolder;


    /**
     * 浏览器上传文件
     * @param files 自动封装上传过来的文件
     * @return Result 统一返回接口
     */
    @Override
    public Result<Object> upload(MultipartFile[] files) throws IOException {

        List<String> urls = new ArrayList<>();
        File dir = new File(uploadFolder);
        if(!dir.exists())
            dir.mkdir();

        for (MultipartFile file : files) {
            //空文件拒绝上传
            if(!file.isEmpty()){
                String fileName = file.getOriginalFilename();
                assert fileName != null;
                int suffixIndex = fileName.lastIndexOf(".");
                String suffix = fileName.substring(suffixIndex);

                String uploadFilename = UUID.randomUUID().toString() + suffix;
                String url = "/jwaoswh"+filePath.substring(0,filePath.length()-2) + uploadFilename;
                urls.add(url);
                System.out.println(uploadFolder + uploadFilename+"aaaaa");

                file.transferTo(new File(uploadFolder + uploadFilename));

            }
        }

        return CommonUtil.successResult(urls);
    }

}
