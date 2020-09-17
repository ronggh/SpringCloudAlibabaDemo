package cn.alan.service;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.alan.entity.Order;

public interface IOrderService extends IService<Order> {
    /**
     * 创建订单
     * 
     * @param order
     */
    void createOrder(Order order);
}
