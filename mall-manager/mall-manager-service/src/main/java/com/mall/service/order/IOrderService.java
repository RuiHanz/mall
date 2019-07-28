package com.mall.service.order;

import com.mall.service.utils.PageBean;

import java.sql.SQLException;
import java.util.List;

public interface IOrderService {
    //删除订单
    public boolean removeOrderService(String dd_id) throws SQLException;
    //修改订单
    public void modifyOrder(Order order, String dd_id);
    public boolean modifyDdService(Order order, String dd_id) throws SQLException;
    //根据订单id查询订单
    public List<Order> findOrderById(String dd_id);
    public void findDdById1Service(PageBean<Order> pageBean, String dd_id) throws SQLException;
    //按收货人模糊查询订单
    public List<Order> findOrderByShhr(String shhr);
    public void findDdByShhr1Service(PageBean<Order> pageBean, String shhr) throws SQLException;
    //按商品名称查询订单
    public List<Order> findOrderByShp_mch(String shp_mch);
    public void findDdByShp_mch1Service(PageBean<Order> pageBean, String shp_mch) throws SQLException;
    //查询所有订单
    public List<Order> findAll();
    public List<Order> findDdAllService() throws SQLException;
    /* 分页查询数据
     * */
    public  void  getAllService(PageBean<Order> pageBean) throws SQLException;
}
