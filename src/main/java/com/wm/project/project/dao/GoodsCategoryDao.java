package com.wm.project.project.dao;

import com.wm.project.project.entity.GoodsCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (GoodsCategory)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-30 16:07:05
 */
public interface GoodsCategoryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param goodsCategoryrId 主键
     * @return 实例对象
     */
    GoodsCategory queryById(String goodsCategoryrId);


    /**
     * 统计总行数
     *
     * @param goodsCategory 查询条件
     * @return 总行数
     */
    long count(GoodsCategory goodsCategory);

    /**
     * 新增数据
     *
     * @param goodsCategory 实例对象
     * @return 影响行数
     */
    int insert(GoodsCategory goodsCategory);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<GoodsCategory> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<GoodsCategory> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<GoodsCategory> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<GoodsCategory> entities);

    /**
     * 修改数据
     *
     * @param goodsCategory 实例对象
     * @return 影响行数
     */
    int update(GoodsCategory goodsCategory);

    /**
     * 通过主键删除数据
     *
     * @param goodsCategoryrId 主键
     * @return 影响行数
     */
    int deleteById(String goodsCategoryrId);
    List<GoodsCategory> selectAll();

}

