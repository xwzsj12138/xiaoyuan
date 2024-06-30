package com.wm.project.project.service;

import com.wm.project.project.entity.Users;


import java.util.List;
import java.util.Map;


/**
 * (Users)表服务接口
 *
 * @author zyf
 * @since 2022-03-15 10:05:18
 */
public interface UsersService {

    /**
     * 登录
     * @param users
     * @return
     */
    Users login(Users users);


    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    int insert(Users users);

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    Users update(Users users);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(String userId);

    List<Users> selectPageByUsers(Map<String, Object> models);

    int IsCancellation(String userId);

    Users WxSelectByUsersId(String userId);
}
