package com.wm.project.project.service;

import com.wm.project.project.entity.Goods;
import com.wm.project.project.entity.GoodsCategory;

import java.util.List;


/**
 * (GoodsCategory)表服务接口
 *
 * @author makejava
 * @since 2022-03-30 16:07:09
 */
public interface GoodsCategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param goodsCategoryrId 主键
     * @return 实例对象
     */
    GoodsCategory queryById(String goodsCategoryrId);


    /**
     * 新增数据
     *
     * @param goodsCategory 实例对象
     * @return 实例对象
     */
    GoodsCategory insert(GoodsCategory goodsCategory);

    /**
     * 修改数据
     *
     * @param goodsCategory 实例对象
     * @return 实例对象
     */
    GoodsCategory update(GoodsCategory goodsCategory);

    /**
     * 通过主键删除数据
     *
     * @param goodsCategoryrId 主键
     * @return 是否成功
     */
    boolean deleteById(String goodsCategoryrId);

    List<GoodsCategory> selectAll();

}
