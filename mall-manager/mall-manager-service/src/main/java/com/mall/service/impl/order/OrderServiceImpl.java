package com.mall.service.impl.order;


import com.mall.service.order.IOrderDao;
import com.mall.service.order.IOrderService;
import com.mall.service.order.Order;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements IOrderService {

    IOrderDao dao = new OrderDaoImpl();
    @Override
    public void addOrder(Order order) {

        try {
            dao.insertOrder(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeOrder(String dd_id) {
        try {
            dao.deleteOrderByid(dd_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifyOrder(Order order) {
        try {
            dao.update(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order findOrderById(String id) {
        Order order =null;
        try {
            order = dao.selectOrderById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public List<Order> findAll() {
        List<Order> orderList = null;
        try {
            orderList=dao.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }
}
