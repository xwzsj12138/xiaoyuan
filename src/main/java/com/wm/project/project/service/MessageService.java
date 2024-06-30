package com.wm.project.project.service;

import com.wm.project.project.entity.Message;


import java.util.List;
import java.util.Map;

/**
 * (Message)表服务接口
 *
 * @author zyf
 * @since 2022-03-18 17:10:41
 */
public interface MessageService {

    /**
     * 通过ID查询单条数据
     *
     * @param messageId 主键
     * @return 实例对象
     */
    Message queryById(String messageId);

    /**
     * 分页查询
     * @param models
     * @return
     */
    List<Message> selectPageByMessage(Map<String, Object> models);

    /**
     * 新增数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
    Message insert(Message message);

    /**
     * 修改数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
    Message update(Message message);

    /**
     * 通过主键删除数据
     *
     * @param messageId 主键
     * @return 是否成功
     */
    boolean deleteById(String messageId);

    /**
     * 审核
     * @param messageId
     * @return
     */
    int examine(String messageId);
    int messageInsert(Message message);

    List<Message> WxSelectAll();
}
