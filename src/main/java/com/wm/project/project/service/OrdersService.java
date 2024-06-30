package com.wm.project.project.service;

import com.wm.project.project.entity.Orders;

import java.util.List;
import java.util.Map;


/**
 * (Orders)表服务接口
 *
 * @author makejava
 * @since 2022-05-07 22:20:15
 */
public interface OrdersService {

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    Orders queryById(String orderId);



    /**
     * 新增数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    Orders insert(Orders orders);

    /**
     * 修改数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    Orders update(Orders orders);

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    boolean deleteById(String orderId);

    int insertOrUpdate(Orders orders);

    /**
     * 分页查询
     * @param models
     * @return
     */
    List<Orders> selectPageByOrder(Map<String, Object> models);
    List<Orders> selectAll(Map<String, Object> models);

    /**
     * 改变订单状态
     * @param orderStatus
     * @return
     */
    int changeOrderStatus(Orders orders);

    List<Orders> selectByUserName(Orders orders);

    List<Orders> selectByUserName2(String userName);

    Orders selectByOrderNo(String orderNo);
}
