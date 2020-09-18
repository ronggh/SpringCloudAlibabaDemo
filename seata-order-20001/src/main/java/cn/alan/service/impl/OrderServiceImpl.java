package cn.alan.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.alan.dao.OrderDao;
import cn.alan.entity.Order;
import cn.alan.service.IAccountService;
import cn.alan.service.IOrderService;
import cn.alan.service.IStorageService;
import io.seata.spring.annotation.GlobalTransactional;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements IOrderService {
    @Resource
    private OrderDao orderDao;

    @Resource
    private IStorageService storageService;

    @Resource
    private IAccountService accountService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态 简单说：下订单->扣库存->减余额->改状态
     */
    @Override
    @GlobalTransactional(name = "order", rollbackFor = Exception.class)
    public void createOrder(Order order) {
        // 1. 下订单
        orderDao.createOrder(order);

        // 2. 扣减库存
        storageService.decrease(order.getProductId(), order.getCount());

        // 3. 扣减账户
        accountService.decrease(order.getUserId(), order.getMoney());

        // 4. 修改订单状态，从0到1,1代表已经完成
        orderDao.updateStatus(order.getUserId(), order.getProductId());

    }
}
