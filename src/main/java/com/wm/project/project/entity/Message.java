package com.wm.project.project.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.io.Serializable;

/**
 * (Message)实体类
 *
 * @author zyf
 * @since 2022-03-18 17:10:41
 */
@Data
@ToString
public class Message implements Serializable {
    private static final long serialVersionUID = -61982491128973291L;
    /**
     * 留言的id
     */
    private String messageId;
    /**
     * 用户表id(在前端尽量显示用户的昵称)
     */
    private String usersNikeId;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 发送时间，默认值
     */
    private Date createTime;
    /**
     * 审核程度，0未审，1已审，2屏蔽
     */
    private Integer examine;
    /**
     * 商品的id（前端显示商品的名字）
     */
    private String goodsId;
    /**
     * 商品的评分
     */
    private Integer goodsSore;



}
