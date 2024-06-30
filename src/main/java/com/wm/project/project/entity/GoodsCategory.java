package com.wm.project.project.entity;

import java.io.Serializable;

/**
 * (GoodsCategory)实体类
 *
 * @author makejava
 * @since 2022-03-30 16:07:05
 */
public class GoodsCategory implements Serializable {
    private static final long serialVersionUID = 730291062174491141L;
    /**
     * 用户主键id
     */
    private String goodsCategoryrId;
    /**
     * 类型名称
     */
    private String name;
    /**
     * 排序
     */
    private Integer sort;


    public String getGoodsCategoryrId() {
        return goodsCategoryrId;
    }

    public void setGoodsCategoryrId(String goodsCategoryrId) {
        this.goodsCategoryrId = goodsCategoryrId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

}

