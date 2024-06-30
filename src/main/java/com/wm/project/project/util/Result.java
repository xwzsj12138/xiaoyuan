package com.wm.project.project.util;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一返回实体
 *
 * @param <T> 返回数据
 * @author zyf
 */
@Data
public class Result<T> implements Serializable {
    /**
     * 返回代码
     */
    private int code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 服务器当前时间戳
     */
    private String timestamp;

    /**
     * 成功数据
     */
    private T data;
}
