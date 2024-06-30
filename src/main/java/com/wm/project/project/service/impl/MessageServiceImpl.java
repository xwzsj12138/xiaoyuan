package com.wm.project.project.service.impl;

import com.wm.project.project.entity.Message;
import com.wm.project.project.dao.MessageDao;
import com.wm.project.project.service.MessageService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * (Message)表服务实现类
 *
 * @author zyf
 * @since 2022-03-18 17:10:41
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageDao messageDao;

    /**
     * 通过ID查询单条数据
     *
     * @param messageId 主键
     * @return 实例对象
     */
    @Override
    public Message queryById(String messageId) {
        return this.messageDao.queryById(messageId);
    }

    @Override
    public List<Message> selectPageByMessage(Map<String, Object> models) {
        return messageDao.selectPageByMessage(models);
    }



    /**
     * 新增数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
    @Override
    public Message insert(Message message) {
        this.messageDao.insert(message);
        return message;
    }

    /**
     * 修改数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
    @Override
    public Message update(Message message) {
        this.messageDao.update(message);
        return this.queryById(message.getMessageId());
    }

    /**
     * 通过主键删除数据
     *
     * @param messageId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String messageId) {
        return this.messageDao.deleteById(messageId) > 0;
    }

    @Override
    public int examine(String messageId) {
        return messageDao.examine(messageId);
    }

    @Override
    public int messageInsert(Message message) {
        String replace = UUID.randomUUID().toString().replace("_", "");
        message.setMessageId(replace);
       String s="/jwaoswh"+ message.getGoodsId();
       message.setGoodsId(s);
        return messageDao.insert(message);
    }

    @Override
    public List<Message> WxSelectAll() {
        List<Message> list2=new ArrayList<>();
        List<Message> list = messageDao.WxSelectAll();
        for(Message message:list){
            String substring = message.getGoodsId().substring(8);
            message.setGoodsId(substring);
            list2.add(message);
        }
        return list2;
    }
}
