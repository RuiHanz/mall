package com.mall.service.order;

import java.sql.SQLException;
import java.util.List;

public interface IOrderDao {
    //添加订单
    public  void   insertOrder(Order order) throws SQLException;
    //删除订单 根据订单编号
    public void  deleteOrderByid(String dd_id) throws SQLException;
    //修改订单
    public  void update(Order order) throws SQLException;
    //通过订单id查询订单
    public Order selectOrderById(String id) throws SQLException;
    //查询所有订单
    public List<Order> selectAll() throws SQLException;
}
