package com.mall.service.order;


import com.mall.service.utils.PageBean;

import java.sql.SQLException;
import java.util.List;

public interface IOrderDao {
    //删除订单 根据订单编号
    public void  deleteOrderByid(String dd_id) throws SQLException;
    //修改订单
    public  void update(Order order, String dd_id) throws SQLException;
    //通过订单id查询订单
    public List<Order> selectOrderById(String dd_id) throws SQLException;
    public void selectDdByDd_id(PageBean<Order> pageBean, String dd_id) throws SQLException;
    //按收货人模糊查询订单
    public List<Order> selectOrderByShhr(String shhr);
    public void selectDdByShhr(PageBean<Order> pageBean, String shhr) throws SQLException;
    //按商品名称模糊查询订单
    public List<Order> selectOrderByShp_mch(String shp_mch);
    public void selectDdByShp(PageBean<Order> pageBean, String shp_mch) throws SQLException;
    //查询所有订单
    public List<Order> selectAll() throws SQLException;
    public List<Order> selectDdAll() throws SQLException;
}
