package com.mall.service.impl.order;


import com.mall.service.order.IOrderDao;
import com.mall.service.order.Order;

import com.mall.service.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl implements IOrderDao {


    @Override
    public void insertOrder(Order order) throws SQLException {
        String sql ="insert into order values(?,?,?,?,?,?,?,?,?,?)";
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        qr.update(sql,order.getDd_id(),order.getYh_id(),order.getChjshj(),order.getZje(),order.getShhr(),
                order.getJdh(),order.getYjsdshj(),order.getDzh_mch(),order.getMai_id(),order.getShp_mch());
    }

    @Override
    public void deleteOrderByid(String dd_id) throws SQLException {
        String sql = "delete from secondProgram1.order where dd_id =?" ;
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        qr.execute(sql,dd_id);
    }

    @Override
    public void update(Order order) throws SQLException {
        String sql = "update order set yh_id=?,chjshj=?,zje=?,shhr=?," +
                "jdh=?,yjsdshj=?,dzh_mch=?,mai_id=?,shp_mch=? where dd_id=?";
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        qr.update(sql,order.getYh_id(),order.getChjshj(),order.getZje(),order.getShhr(),order.getJdh(),
                order.getYjsdshj(),order.getDzh_mch(),order.getMai_id(),order.getShp_mch(),order.getDd_id() );
    }

    @Override
    public Order selectOrderById(String id) throws SQLException {
        String sql = "select * from order where dd_id=?";
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        Order order =null;
        order = qr.query(sql,new BeanHandler<>(Order.class),id);
        return order;
    }

    @Override
    public List<Order> selectAll() throws SQLException {
        String sql = "select * from secondProgram1.order";
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        List<Order> orderList = qr.query(sql,new BeanListHandler<>(Order.class));
        return orderList;
    }
}
