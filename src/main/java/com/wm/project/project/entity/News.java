package com.wm.project.project.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (News)实体类
 *
 * @author zyf
 * @since 2022-03-09 13:50:28
 */
@Data
public class News implements Serializable {
    private static final long serialVersionUID = 225454872510551502L;
    /**
     * 主键
     */
    private String uuid;
    /**
     * 热点新闻标题
     */
    private String title;
    /**
     * 热点新闻图片
     */
    private String image;
    /**
     * 获取到新闻的时间
     */
    private Date createTime;
    /**
     * 新闻对应的网络地址
     */
    private String newsUrl;
}

