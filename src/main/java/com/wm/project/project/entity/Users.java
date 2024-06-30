package com.wm.project.project.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Users)实体类
 *
 * @author zyf
 * @since 2022-03-15 10:05:16
 */
@Data
public class Users implements Serializable {
    private static final long serialVersionUID = 105369311225520152L;
    /**
     * 用户主键id
     */
    private String userId;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 登陆名称(默认为学号)
     */
    private String loginName;
    /**
     * MD5加密后的密码
     */
    private String passwordMd5;
    /**
     * 个性签名
     */
    private String introduceSign;
    /**
     * 收货地址
     */
    private String address;
    /**
     * 注销标识字段(0-正常 1-已注销)
     */
    private Integer isDeleted;
    /**
     * 锁定标识字段(0-未锁定 1-已锁定)
     */
    private Integer lockedFlag;
    /**
     * 注册时间
     */
    private Date createTime;

    private  Integer role ;

    private String studentName;

    private String phone;

    /**
     * 登录验证
     */
    private  String token;

    /**
     * 头像
     */
    private String headUrl;





}
