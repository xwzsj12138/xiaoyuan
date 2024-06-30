package com.wm.project.project.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wm.project.project.entity.Goods;
import com.wm.project.project.entity.Message;
import com.wm.project.project.service.MessageService;

import com.wm.project.project.util.CommonUtil;
import com.wm.project.project.util.PageResult;
import com.wm.project.project.util.Result;
import com.wm.project.project.util.page.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Message)表控制层
 *
 * @author zyf
 * @since 2022-03-18 17:10:40
 */
@RestController
@RequestMapping("message")
public class MessageController {
    /**
     * 服务对象
     */
    @Resource
    private MessageService messageService;

    /**
     * 分页查询
     * @param models
     * @return
     */
    @PostMapping("selectPageByMessage")
    public PageResult selectPageByMessage(@RequestBody Map<String, Object> models) {
        PageRequest pageRequest = JSON.parseObject(JSON.toJSONString(models.get("pageRequest")), PageRequest.class);
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<Message> messages = messageService.selectPageByMessage(models);
        return new PageResult(new PageInfo<>(messages));
    }

    @GetMapping("deleteById")
    public Result<Object> deleteById(String messageId){
        boolean b = messageService.deleteById(messageId);
        if(b){
            return CommonUtil.successResult();
        }else {
            return CommonUtil.errorResult();
        }
    }

    /**
     * 审核发布
     * @param messageId
     * @return
     */
    @GetMapping("examine")
    public Result<Object> examine(String messageId){
        int b= messageService.examine(messageId);
        if(b>0){
            return CommonUtil.successResult();
        }else {
            return CommonUtil.errorResult();
        }
    }

    @PostMapping("messageInsert")
    public Result<Object> messageInsert(@RequestBody Message message){
        int i= messageService.messageInsert(message);
        if(i>0){
            return CommonUtil.successResult();
        }else {
            return CommonUtil.errorResult();
        }
    }


    @GetMapping("WxSelectAll")
    public Result<Object> WxSelectAll(){
        List<Message> list= messageService.WxSelectAll();
        if(list!=null){
            return CommonUtil.successResult(list);
        }else {
            return CommonUtil.errorResult();
        }
    }

}
