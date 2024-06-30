package com.wm.project.project.service.impl;

import com.wm.project.project.entity.Schooldatabase;
import com.wm.project.project.dao.SchooldatabaseDao;
import com.wm.project.project.service.SchooldatabaseService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * (Schooldatabase)表服务实现类
 *
 * @author zyf
 * @since 2022-03-15 16:22:24
 */
@Service("schooldatabaseService")
public class SchooldatabaseServiceImpl implements SchooldatabaseService {
    @Resource
    private SchooldatabaseDao schooldatabaseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Schooldatabase queryById(String id) {
        return this.schooldatabaseDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param schooldatabase 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */


    /**
     * 新增数据
     *
     * @param schooldatabase 实例对象
     * @return 实例对象
     */
    @Override
    public Schooldatabase insert(Schooldatabase schooldatabase) {
        this.schooldatabaseDao.insert(schooldatabase);
        return schooldatabase;
    }

    /**
     * 修改数据
     *
     * @param schooldatabase 实例对象
     * @return 实例对象
     */
    @Override
    public Schooldatabase update(Schooldatabase schooldatabase) {
        this.schooldatabaseDao.update(schooldatabase);
        return this.queryById(schooldatabase.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.schooldatabaseDao.deleteById(id) > 0;
    }

    @Override
    public Schooldatabase selectByStudentNumber(String studentNumber) {
        return schooldatabaseDao.selectByStudentNumber(studentNumber);
    }
}
