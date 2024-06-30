package com.wm.project.project.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取application.yml中的自定义数据
 */
@Data
@Component
@ConfigurationProperties(prefix = "file")
public class FileProperties {
    private String filePath;

    private String uploadFolder;
}
