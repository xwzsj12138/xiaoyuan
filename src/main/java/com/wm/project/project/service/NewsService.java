package com.wm.project.project.service;

import com.wm.project.project.entity.News;

import java.util.List;

/**
 * (News)表服务接口
 *
 * @author zyf
 * @since 2022-03-09 13:50:29
 */
public interface NewsService {

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
     * @return 实例对象
     */
    News insert(News news);

    /**
     * 修改数据
     *
     * @param news 实例对象
     * @return 实例对象
     */
    News update(News news);

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 是否成功
     */
    boolean deleteById(String uuid);

    List<News> selectAll();
}
