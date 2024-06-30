package com.wm.project.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wm.project.project.config.CommonException;
import com.wm.project.project.dao.SchooldatabaseDao;
import com.wm.project.project.entity.Schooldatabase;
import com.wm.project.project.entity.Users;
import com.wm.project.project.dao.UsersDao;
import com.wm.project.project.service.UsersService;
import com.wm.project.project.util.CommonUtil;
import com.wm.project.project.util.Md5Utils;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * (Users)表服务实现类
 *
 * @author zyf
 * @since 2022-03-15 10:05:18
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersDao usersDao;
    @Resource
    private SchooldatabaseDao schooldatabaseDao;



    /**
     * 登录
     * @param users
     * @return
     */
    @Override
    public Users login(Users users) {
        String md51 = Md5Utils.getMD5(users.getPasswordMd5());
        Users users1 = usersDao.selectByLoginName(users.getLoginName());
        if(users1.getIsDeleted()==1){
            throw new CommonException("改用户已被注销锁定！详情请联系管理员！");
        }

        if(md51.equals(users1.getPasswordMd5())){
            return users1;
        }else {
            return null;
        }
    }

    /**
     * 注册
     * @param users 实例对象
     * @return
     */

    @Override
    public int insert(Users users) {
        //类似于做一个实名验证
        Schooldatabase schooldatabase = schooldatabaseDao.selectByStudentNumber(users.getLoginName());
        if(!schooldatabase.getStudentName().equals(users.getStudentName())){
            throw new CommonException("请填写正确的学号或姓名！");
        }

        Users users1 = usersDao.selectByLoginName(users.getLoginName());
        if(users1!=null){
            throw new CommonException("用户名重复！");
        }else {
            String id = UUID.randomUUID().toString();
            users.setUserId(id);
            //密码加密
            String md5 = Md5Utils.getMD5(users.getPasswordMd5());
            users.setPasswordMd5(md5);
            return usersDao.insert(users);
        }
    }

    @Override
    public Users update(Users users) {
        return null;
    }


    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String userId) {
        return this.usersDao.deleteById(userId) > 0;
    }

    @Override
    public List<Users> selectPageByUsers(Map<String, Object> models) {
        return usersDao.selectPageByUsers(models);
    }

    @Override
    public int IsCancellation(String userId) {
        return usersDao.IsCancellation(userId);
    }

    @Override
    public Users WxSelectByUsersId(String userId) {
        Users users = usersDao.selectByUsersId(userId);
        users.setHeadUrl(users.getHeadUrl().substring(8));
        return users;
    }
}
