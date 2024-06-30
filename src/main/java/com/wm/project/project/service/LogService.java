package com.wm.project.project.service;

import com.jfinal.template.stat.ast.Return;
import com.wm.project.project.config.CommonException;
import com.wm.project.project.util.CommonUtil;
import com.wm.project.project.util.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Service
public class LogService {

    public void logDownload(String name, HttpServletResponse response) throws Exception {
        File file = new File("E:\\wm\\logs" + File.separator + name);
        if (!file.exists()) {
            System.out.println("文件不存在");
            throw new CommonException(name + "文件不存在");
        }
        response.setContentType("application/force-download");
        response.addHeader("Content-Disposition", "attachment;fileName=" + name);

        byte[] buffer = new byte[1024];
        try (FileInputStream fis = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(fis)) {

            OutputStream os = response.getOutputStream();

            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        }
    }

    public Result<Object> logUpload(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new CommonException("文件不能为空！");
        }
        String filePath = new File("E:\\wm\\upload").getAbsolutePath();
        File fileUpload = new File(filePath);
        if (!fileUpload.exists()) {
            fileUpload.mkdirs();
        }

        fileUpload = new File(filePath, file.getOriginalFilename());

        if (fileUpload.exists()) {
            throw new CommonException("文件已经存在！");
        }

        try {
            file.transferTo(fileUpload);
            //返回路径作为url（便于存入数据库）
            return CommonUtil.successResult(filePath);
        } catch (IOException e) {
            throw new CommonException("上传文件到服务器失败：" + e.toString());
        }
    }




}

