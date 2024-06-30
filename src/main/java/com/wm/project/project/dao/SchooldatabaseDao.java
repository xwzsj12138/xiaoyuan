package com.wm.project.project.dao;

import com.wm.project.project.entity.Schooldatabase;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Schooldatabase)表数据库访问层
 *
 * @author zyf
 * @since 2022-03-15 16:22:23
 */
public interface SchooldatabaseDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Schooldatabase queryById(String id);



    /**
     * 统计总行数
     *
     * @param schooldatabase 查询条件
     * @return 总行数
     */
    long count(Schooldatabase schooldatabase);

    /**
     * 新增数据
     *
     * @param schooldatabase 实例对象
     * @return 影响行数
     */
    int insert(Schooldatabase schooldatabase);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Schooldatabase> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Schooldatabase> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Schooldatabase> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Schooldatabase> entities);

    /**
     * 修改数据
     *
     * @param schooldatabase 实例对象
     * @return 影响行数
     */
    int update(Schooldatabase schooldatabase);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    /**
     * 查询学生信息
     * @param studentNumber
     * @return
     */
    Schooldatabase selectByStudentNumber(String loginName);

}
