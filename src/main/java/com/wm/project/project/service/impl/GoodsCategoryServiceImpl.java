package com.wm.project.project.service.impl;

import com.wm.project.project.entity.GoodsCategory;
import com.wm.project.project.dao.GoodsCategoryDao;
import com.wm.project.project.service.GoodsCategoryService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * (GoodsCategory)表服务实现类
 *
 * @author makejava
 * @since 2022-03-30 16:07:09
 */
@Service("goodsCategoryService")
public class GoodsCategoryServiceImpl implements GoodsCategoryService {
    @Resource
    private GoodsCategoryDao goodsCategoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param goodsCategoryrId 主键
     * @return 实例对象
     */
    @Override
    public GoodsCategory queryById(String goodsCategoryrId) {
        return this.goodsCategoryDao.queryById(goodsCategoryrId);
    }



    /**
     * 新增数据
     *
     * @param goodsCategory 实例对象
     * @return 实例对象
     */
    @Override
    public GoodsCategory insert(GoodsCategory goodsCategory) {
        this.goodsCategoryDao.insert(goodsCategory);
        return goodsCategory;
    }

    /**
     * 修改数据
     *
     * @param goodsCategory 实例对象
     * @return 实例对象
     */
    @Override
    public GoodsCategory update(GoodsCategory goodsCategory) {
        this.goodsCategoryDao.update(goodsCategory);
        return this.queryById(goodsCategory.getGoodsCategoryrId());
    }

    /**
     * 通过主键删除数据
     *
     * @param goodsCategoryrId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String goodsCategoryrId) {
        return this.goodsCategoryDao.deleteById(goodsCategoryrId) > 0;
    }

    @Override
    public List<GoodsCategory> selectAll() {
        return goodsCategoryDao.selectAll();
    }
}
