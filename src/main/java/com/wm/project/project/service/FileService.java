package com.wm.project.project.service;

import com.wm.project.project.util.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author zyf
 * @since 2022/3/14 11:19
 */
public interface FileService {
    /**
     * 下载文件
     * @param files
     * @return
     * @throws IOException
     */
    Result<Object> upload(MultipartFile[] files) throws IOException;
}
