package com.wm.project.project.service;

import com.wm.project.project.entity.Schooldatabase;


/**
 * (Schooldatabase)表服务接口
 *
 * @author zyf
 * @since 2022-03-15 16:22:24
 */
public interface SchooldatabaseService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Schooldatabase queryById(String id);



    /**
     * 新增数据
     *
     * @param schooldatabase 实例对象
     * @return 实例对象
     */
    Schooldatabase insert(Schooldatabase schooldatabase);

    /**
     * 修改数据
     *
     * @param schooldatabase 实例对象
     * @return 实例对象
     */
    Schooldatabase update(Schooldatabase schooldatabase);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

    /**
     * 查询学生信息
     * @param studentNumber
     * @return
     */
    Schooldatabase selectByStudentNumber(String studentNumber);

}
