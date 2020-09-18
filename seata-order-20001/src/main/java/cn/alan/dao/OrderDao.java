package cn.alan.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.alan.entity.Order;

@Mapper
public interface OrderDao extends BaseMapper<Order> {
    /**
     * 创建订单
     * 
     * @param order
     */
    @Insert("Insert into order_tbl (user_id,product_id,count,money,status) "
        + " values (#{userId},#{productId},#{count},#{money},0)")
    void createOrder(Order order);

    /**
     * 更新订单状态，从0 ---> 1
     * 
     * @param userId
     * @param productId
     * @param status
     */
    @Update("UPDATE order_tbl SET status = 1 "
        + " WHERE user_id = #{userId} and product_id = #{productId} and status = 0")
    void updateStatus(@Param("userId") Long userId, @Param("productId") Long productId);
}
