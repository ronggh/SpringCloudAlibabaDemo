package cn.alan.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.alan.entity.Order;

@Mapper
public interface OrderDao extends BaseMapper<Order> {

}
