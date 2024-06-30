package com.wm.project.project.service;

import com.wm.project.project.entity.Goods;

import java.util.List;
import java.util.Map;


/**
 * (Goods)表服务接口
 *
 * @author zyf
 * @since 2022-03-18 13:13:10
 */
public interface GoodsService {

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
    Goods queryById(String goodsId);

    /**
     * 分页查询
     *
     * @param
     * @return 查询结果
     */
    List<Goods> selectPageByGoods(Map<String, Object> models);

    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    Goods insert(Goods goods);

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    Goods update(Goods goods);

    /**
     * 通过主键删除数据
     *
     * @param goodsId 主键
     * @return 是否成功
     */
    boolean deleteById(String goodsId);

    /**
     * 商品的上架与下架操作
     * @param goodsId
     * @return
     */
    int commit(String goodsId);

    int insertOrUpdate(Goods goods);

    /**
     * 申请操作（修改isApplyed字段）
     * @param goodsId
     * @return
     */
    int isApplyedByGoodsId(String goodsId);

    List<Goods> selectAll();

    /**
     * 微信接口查询分类得商品信息
     * @param goodsCategoryId
     * @return
     */
    List<Goods> WxSelectByGoodsCategoryId(String goodsCategoryId);

    /**
     * 查询单条数据
     * @param goodsId
     * @return
     */
    Goods WxSelectByGoodsId(String goodsId);
}
