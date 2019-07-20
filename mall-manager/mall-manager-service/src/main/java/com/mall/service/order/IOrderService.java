package com.mall.service.order;

import java.util.List;

public interface IOrderService {
    //添加订单
    public void addOrder(Order order);
    //删除订单
    public void removeOrder(String dd_id);
    //修改订单
    public void modifyOrder(Order order);
    //查询单个订单
    public Order findOrderById(String id);
    //查询所有订单
    public List<Order> findAll();
}
