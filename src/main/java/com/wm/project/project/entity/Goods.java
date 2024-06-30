package com.wm.project.project.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.io.Serializable;

/**
 * (Goods)实体类
 *
 * @author zyf
 * @since 2022-03-18 13:13:10
 */
@Data
@ToString
public class Goods implements Serializable {
    private static final long serialVersionUID = 518328260968520530L;
    /**
     * 商品表主键id
     */
    private String goodsId;
    /**
     * 商品名
     */
    private String goodsName;
    /**
     * 商品简介
     */
    private String goodsIntro;
    /**
     * 关联分类id
     */
    private String goodsCategoryId;
    /**
     * 商品价格
     */
    private Integer originalPrice;
    /**
     * 商品实际售价
     */
    private Integer sellingPrice;
    /**
     * 商品库存数量
     */
    private Integer stockNum;
    /**
     * 商品标签
     */
    private String tag;
    /**
     * 商品上架状态 0-下架 1-上架
     */
    private Integer goodsSellStatus;
    /**
     * 添加者主键id
     */
    private String createUser;
    /**
     * 商品添加时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date createTime;
    /**
     * 修改者主键id
     */
    private Integer updateUser;
    /**
     * 商品修改时间
     */
    private Date updateTime;
    /**
     * 是否已经申请上架（管理员只能查看到已经申请过的商品）
     */
    private String isApplyed;


    public Goods() {
    }
}
