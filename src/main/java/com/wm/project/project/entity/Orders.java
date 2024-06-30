package com.wm.project.project.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.io.Serializable;

/**
 * (Orders)实体类
 *
 * @author makejava
 * @since 2022-05-07 22:20:13
 */
@Data
@ToString
public class Orders implements Serializable {
    private static final long serialVersionUID = -51575899901374513L;
    /**
     * 订单表主键id
     */
    private String orderId;
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 用户主键id
     */
    private String userId;
    /**
     * 订单总价
     */
    private Integer totalPrice;
    /**
     * 支付状态:0.未支付,1.支付成功,-1:支付失败
     */
    private Integer payStatus;
    /**
     * 0.无 1.支付宝支付 2.微信支付
     */
    private Integer payType;
    /**
     * 支付时间
     */
    private Date payTime;
    /**
     * 订单状态:0.待支付 1.已支付 2.配货完成 3:出库成功 4.交易成功 -1.手动关闭 -2.超时关闭 -3.商家关闭
     */
    private Integer orderStatus;
    /**
     * 收货人姓名
     */
    private String userName;
    /**
     * 收货人手机号
     */
    private String userPhone;
    /**
     * 收货人收货地址
     */
    private String userAddress;
    /**
     * 删除标识字段(0-未删除 1-已删除)
     */
    private Integer isDeleted;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最新修改时间
     */
    private Date updateTime;

    /**
     * 商品图片
     */
    private String goodsIntro;

}

