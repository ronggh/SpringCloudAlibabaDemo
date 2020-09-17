package cn.alan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.alan.entity.CommonResult;
import cn.alan.entity.Order;
import cn.alan.service.IOrderService;

/**
 * @author : Alan
 */
@RestController
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @GetMapping("/order/create")
    public CommonResult<Order> create(Order order) {
        orderService.createOrder(order);
        return new CommonResult<>(200, "订单创建成功", order);
    }

}
