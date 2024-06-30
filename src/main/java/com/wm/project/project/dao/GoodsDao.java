package com.wm.project.project.dao;

import com.wm.project.project.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * (Goods)表数据库访问层
 *
 * @author zyf
 * @since 2022-03-18 13:13:08
 */
public interface GoodsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
    Goods queryById(String goodsId);



    /**
     * 统计总行数
     *
     * @param goods 查询条件
     * @return 总行数
     */
    long count(Goods goods);

    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 影响行数
     */
    int insert(Goods goods);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Goods> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Goods> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Goods> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Goods> entities);

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 影响行数
     */
    int update(Goods goods);

    /**
     * 通过主键删除数据
     *
     * @param goodsId 主键
     * @return 影响行数
     */
    int deleteById(String goodsId);

    List<Goods> selectPageByGoods(Map<String, Object> models);

    int putShelf(String goodsId);

   int  downShelf(String goodsId);

   int isApplyedByGoodsId(String goodsId);

   List<Goods> selectAll();

    /**
     * 查询分类得商品信息
     * @param goodsCategoryId
     * @return
     */
   List<Goods> selectByGoodsCategoryId(String goodsCategoryId);

    Goods selectByGoodsId(String goodsId);

}
