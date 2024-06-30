package com.wm.project.project.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wm.project.project.entity.Orders;
import com.wm.project.project.entity.Users;
import com.wm.project.project.service.OrdersService;

import com.wm.project.project.util.CommonUtil;
import com.wm.project.project.util.PageResult;
import com.wm.project.project.util.Result;
import com.wm.project.project.util.page.PageRequest;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Orders)表控制层
 *
 * @author makejava
 * @since 2022-05-07 22:20:13
 */
@RestController
@RequestMapping("orders")
public class OrdersController {
    /**
     * 服务对象
     */
    @Resource
    private OrdersService ordersService;

    /**
     * 增加或者修改的操作
     * @param
     * @return
     */
    @PostMapping("insertOrUpdate")
    public Result<Object> insertOrUpdate(@RequestBody Orders orders) {
        int i = ordersService.insertOrUpdate(orders);
        if(i==1){
            return CommonUtil.successResult();
        }else {
            return  CommonUtil.errorResult("操作失败");
        }
    }

    @PostMapping("selectPageByOrders")
    public PageResult selectPageByOrder(@RequestBody Map<String, Object> models) {
        PageRequest pageRequest = JSON.parseObject(JSON.toJSONString(models.get("pageRequest")), PageRequest.class);
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<Orders> orders = ordersService.selectPageByOrder(models);

        return new PageResult(new PageInfo<>(orders));
    }

    @PostMapping("selectAll")
    public PageResult selectPageByOrder2(@RequestBody Map<String, Object> models) {
        PageRequest pageRequest = JSON.parseObject(JSON.toJSONString(models.get("pageRequest")), PageRequest.class);
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<Orders> orders = ordersService.selectAll(models);

        return new PageResult(new PageInfo<>(orders));
    }

    /**
     * 修改订单状态
     * @param orders
     * @return
     */
    @PostMapping("changeOrderStatus")
    public Result<Object> changeOrderStatus(@RequestBody Orders orders) {
        int i=ordersService.changeOrderStatus(orders);
    if(i>0){
        return CommonUtil.successResult();
    }else {
        return CommonUtil.errorResult("操作失败");
    }

    }

    /**
     * 查询订单内容
     * @param orders
     * @return
     */
    @PostMapping("selectByUserName")
    public Result<Object> selectByUserName(@RequestBody Orders orders) {

        List<Orders> list=ordersService.selectByUserName(orders);
        if(list!=null){
            return CommonUtil.successResult(list);
        }else {
            return CommonUtil.errorResult("操作失败");
        }

    }

    @GetMapping("selectByUserName2")
    public Result<Object> selectByUserName2( String  userName) {

        List<Orders> list=ordersService.selectByUserName2(userName);
        if(list!=null){
            return CommonUtil.successResult(list);
        }else {
            return CommonUtil.errorResult("操作失败");
        }

    }

    @GetMapping("deleteById")
    public Result<Object> deleteById(String orderId) {

        boolean b = ordersService.deleteById(orderId);
        if(b){
            return CommonUtil.successResult();
        }else {
            return CommonUtil.errorResult("操作失败");
        }

    }
    @GetMapping("selectByOrderNo")
    public Result<Object> selectByOrderNo(String orderNo) {

        Orders orders= ordersService.selectByOrderNo(orderNo);
        if(orders!=null){
            return CommonUtil.successResult(orders);
        }else {
            return CommonUtil.errorResult("操作失败");
        }

    }

}

