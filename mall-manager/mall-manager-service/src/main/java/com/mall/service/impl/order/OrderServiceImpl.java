package com.mall.service.impl.order;


import com.mall.service.order.IOrderDao;
import com.mall.service.order.IOrderDaoPage;
import com.mall.service.order.IOrderService;
import com.mall.service.order.Order;
import com.mall.service.utils.PageBean;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements IOrderService {
    //删除订单
    @Override
    public boolean removeOrderService(String dd_id) throws SQLException {
        IOrderDao dao = new OrderDaoImpl();
        dao.deleteOrderByid(dd_id);
        return false;
    }

    //修改订单
    @Override
    public void modifyOrder(Order order, String dd_id) {
        IOrderDao dao = new OrderDaoImpl();
        try {
            dao.update(order,dd_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean modifyDdService(Order order, String dd_id) throws SQLException {
       IOrderDao dao =new OrderDaoImpl();
       dao.update(order,dd_id);
        return false;
    }

    //根据订单id查询订单
    @Override
    public List<Order> findOrderById(String dd_id) {
        IOrderDao dao = new OrderDaoImpl();
        List<Order> orderList =null;
        try {
            orderList =dao.selectOrderById(dd_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public void findDdById1Service(PageBean<Order> pageBean, String dd_id) throws SQLException {
        IOrderDao dao = new OrderDaoImpl();
        dao.selectDdByDd_id(pageBean, dd_id);
    }

    //按收货人模糊查询订单
    @Override
    public List<Order> findOrderByShhr(String shhr) {
        IOrderDao dao = new OrderDaoImpl();
        List<Order> orderList =null;
        orderList = dao.selectOrderByShhr(shhr);
        return orderList;
    }

    @Override
    public void findDdByShhr1Service(PageBean<Order> pageBean, String shhr) throws SQLException {
        IOrderDao dao = new OrderDaoImpl();
        dao.selectDdByShhr(pageBean, shhr);
    }

    //按商品名称查询订单
    @Override
    public List<Order> findOrderByShp_mch(String shp_mch) {
        IOrderDao dao = new OrderDaoImpl();
        List<Order> orderList =null;
        orderList = dao.selectOrderByShp_mch(shp_mch);
        return orderList;
    }

    @Override
    public void findDdByShp_mch1Service(PageBean<Order> pageBean, String shp_mch) throws SQLException {
        IOrderDao dao = new OrderDaoImpl();
        dao.selectDdByShp(pageBean, shp_mch);
    }

    //查询所有订单
    @Override
    public List<Order> findAll() {
        IOrderDao dao = new OrderDaoImpl();
        List<Order> orderList =null;
        try {
            orderList = dao.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public List<Order> findDdAllService() throws SQLException {
        IOrderDao dao = new OrderDaoImpl();
        List<Order> orderList =null;
        orderList = dao.selectDdAll();
        return orderList;
    }

    @Override
    public void getAllService(PageBean<Order> pageBean) throws SQLException {
        IOrderDaoPage dao = new OrderDaoPageImpl();
        dao.getAll(pageBean);

    }
}
