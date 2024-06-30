package com.wm.project.project.dao;

import com.wm.project.project.entity.News;

import java.util.List;

/**
 * (News)表数据库访问层
 *
 * @author zyf
 * @since 2022-03-09 13:50:26
 */
public interface NewsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    News selectById(String uuid);

    /**
     * 新增数据
     *
     * @param news 实例对象
     * @return 影响行数
     */
    int insert(News news);

    /**
     * 修改数据
     *
     * @param news 实例对象
     * @return 影响行数
     */
    int update(News news);

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 影响行数
     */
    int deleteById(String uuid);

    List<News> selectAll();
}

