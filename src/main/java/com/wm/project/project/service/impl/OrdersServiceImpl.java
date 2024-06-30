package com.wm.project.project.service.impl;

import com.wm.project.project.entity.Goods;
import com.wm.project.project.entity.Orders;
import com.wm.project.project.dao.OrdersDao;
import com.wm.project.project.service.OrdersService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * (Orders)表服务实现类
 *
 * @author makejava
 * @since 2022-05-07 22:20:15
 */
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private OrdersDao ordersDao;

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    @Override
    public Orders queryById(String orderId) {
        return this.ordersDao.queryById(orderId);
    }



    /**
     * 新增数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    @Override
    public Orders insert(Orders orders) {
        this.ordersDao.insert(orders);
        return orders;
    }

    /**
     * 修改数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    @Override
    public Orders update(Orders orders) {
        this.ordersDao.update(orders);
        return this.queryById(orders.getOrderId());
    }

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String orderId) {
        return this.ordersDao.deleteById(orderId) > 0;
    }

    @Override
    public int insertOrUpdate(Orders orders) {
        //做一个判断，对于同一个订单号的订单不能重复生成
        Orders orders1 = ordersDao.selectByOrderNo(orders.getOrderNo());
        if(orders1!=null){
            return 0;
        }
        String replace = UUID.randomUUID().toString().replace("_", "");
        String s="/jwaoswh"+orders.getGoodsIntro();
        orders.setGoodsIntro(s);
        orders.setOrderId(replace);
        orders.setPayStatus(0);
        orders.setPayType(0);
        orders.setOrderStatus(0);
        return ordersDao.insert(orders);
    }

    @Override
    public List<Orders> selectPageByOrder(Map<String, Object> models) {
        return ordersDao.selectPageByOrder(models);
    }

    @Override
    public List<Orders> selectAll(Map<String, Object> models) {
        return ordersDao.selectAll(models);
    }

    @Override
    public int changeOrderStatus(Orders orders) {
        return ordersDao.changeOrderStatus(orders);
    }

    @Override
    public List<Orders> selectByUserName(Orders orders) {
        List<Orders> listOrders1 = ordersDao.selectByUserName(orders);
        List<Orders> listOrders2=new ArrayList<>();
        for(Orders orders1:listOrders1){
            String substring = orders1.getGoodsIntro().substring(8);
            orders1.setGoodsIntro(substring);
            listOrders2.add(orders1);
        }
        return listOrders2;
    }

    /**
     * 查询所有订单信息订单
     * @param userName
     * @return
     */
    @Override
    public  List<Orders> selectByUserName2(String userName) {
        List<Orders> listOrders1 = ordersDao.selectByUserName2(userName);
        List<Orders> listOrders2=new ArrayList<>();
        for(Orders orders1:listOrders1){
            String substring = orders1.getGoodsIntro().substring(8);
            orders1.setGoodsIntro(substring);
            listOrders2.add(orders1);
        }
        return listOrders2;
    }

    @Override
    public Orders selectByOrderNo(String orderNo) {
        Orders orders = ordersDao.selectByOrderNo(orderNo);
        String substring = orders.getGoodsIntro().substring(8);
        orders.setGoodsIntro(substring);
        return orders;
    }
}
