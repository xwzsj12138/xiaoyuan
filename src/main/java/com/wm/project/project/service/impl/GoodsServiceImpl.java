package com.wm.project.project.service.impl;

import com.wm.project.project.entity.Goods;
import com.wm.project.project.dao.GoodsDao;
import com.wm.project.project.service.GoodsService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * (Goods)表服务实现类
 *
 * @author zyf
 * @since 2022-03-18 13:13:10
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDao goodsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
    @Override
    public Goods queryById(String goodsId) {
        return this.goodsDao.queryById(goodsId);
    }

    @Override
    public List<Goods> selectPageByGoods(Map<String, Object> models) {
        return goodsDao.selectPageByGoods(models);
    }


    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public Goods insert(Goods goods) {
        this.goodsDao.insert(goods);
        return goods;
    }

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public Goods update(Goods goods) {
        this.goodsDao.update(goods);
        return this.queryById(goods.getGoodsId());
    }

    /**
     * 通过主键删除数据
     *
     * @param goodsId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String goodsId) {
        return this.goodsDao.deleteById(goodsId) > 0;
    }

    @Override
    public int commit(String goodsId) {
        Goods goods = goodsDao.queryById(goodsId);
        //改变状态执行上架操作
        if(goods.getGoodsSellStatus() == 0){
          return   goodsDao.putShelf(goodsId);
        }

        //下架操作
        if(goods.getGoodsSellStatus() == 1){
         return    goodsDao.downShelf(goodsId);
        }
        return 0;
    }

    @Override
    public int insertOrUpdate(Goods goods) {
        if(goods.getGoodsId() == null){
            String replace = UUID.randomUUID().toString().replace("_", "");
            goods.setGoodsId(replace);
            return   goodsDao.insert(goods);
        }
        return  goodsDao.update(goods);

    }

    @Override
    public int isApplyedByGoodsId(String goodsId) {
        return goodsDao.isApplyedByGoodsId(goodsId);
    }

    @Override
    public List<Goods> selectAll() {
        return goodsDao.selectAll();
    }

    @Override
    public List<Goods> WxSelectByGoodsCategoryId(String goodsCategoryId) {
        List<Goods> list=new ArrayList<>();

        List<Goods> list1 = goodsDao.selectByGoodsCategoryId(goodsCategoryId);
        for(Goods goods:list1){
            String substring = goods.getGoodsIntro().substring(8);
            goods.setGoodsIntro(substring);
            list.add(goods);
        }
        return list;
    }

    @Override
    public Goods WxSelectByGoodsId(String goodsId) {
        Goods goods = goodsDao.selectByGoodsId(goodsId);
        String substring = goods.getGoodsIntro().substring(8);
        goods.setGoodsIntro(substring);
        return goods;
    }
}
