package com.mall.service.impl.order;


import com.mall.service.order.IOrderDao;
import com.mall.service.order.Order;

import com.mall.service.utils.JdbcUtils;
import com.mall.service.utils.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl implements IOrderDao {

    //删除订单 根据订单编号
    @Override
    public void deleteOrderByid(String dd_id) throws SQLException {
        String sql = "delete from `order`where dd_id =?" ;
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        qr.update(sql,dd_id);
    }
    //修改订单
    @Override
    public void update(Order order,String dd_id) throws SQLException {
        String sql = "update `order` set dd_id=?,yh_id=?,chjshj=?,zje=?,shhr=?," +
                "jdh=?,yjsdshj=?,dzh_mch=?,mai_id=?,shp_mch=? where dd_id=?";
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        qr.update(sql,order.getDd_id(),order.getYh_id(),order.getChjshj(),order.getZje(),order.getShhr(),order.getJdh(),
                order.getYjsdshj(),order.getDzh_mch(),order.getMai_id(),order.getShp_mch(),dd_id);
    }
    //通过订单id查询订单
    @Override
    public List<Order> selectOrderById(String dd_id) throws SQLException {
        String sql = "select * from `order` where dd_id=?";
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        List<Order> orderList = qr.query(sql.toString(),new BeanListHandler<Order>(Order.class),dd_id);
        return orderList;
    }

    @Override
    public void selectDdByDd_id(PageBean<Order> pageBean, String dd_id) throws SQLException {
        String sql = "select * from `order` where dd_id=?";
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        //查询总记录数；  并设置保存到pageBean对象中
        int totalCount =1;
        pageBean.setTotalCount(totalCount);

        if (pageBean.getCurrentPage() <= 0) {
            pageBean.setCurrentPage(1);
        } else if (pageBean.getCurrentPage() > pageBean.getTotalPage()) {
            pageBean.setCurrentPage(pageBean.getTotalPage());
        }
        //获取当前页：计算查询的起始行、返回行数
        int currentPage = pageBean.getCurrentPage();
        int index = (currentPage - 1) * pageBean.getPageCount();
        int count = pageBean.getPageCount();
        List<Order> orderList=qr.query(sql.toString(), new BeanListHandler<Order>(Order.class),dd_id);
        pageBean.setList(orderList);
    }

    //按收货人模糊查询订单
    @Override
    public List<Order> selectOrderByShhr(String shhr) {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select * from  `order` where shhr like '%' ? '%'";
        List<Order> orderList =null;
        try {
            orderList = qr.query(sql.toString(),new BeanListHandler<Order>(Order.class),shhr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public void selectDdByShhr(PageBean<Order> pageBean, String shhr) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select * from  `order` where shhr like '%' ? '%'";
        //查询总记录数；  并设置保存到pageBean对象中
        int totalCount = getTotalCountShhr(shhr);
        pageBean.setTotalCount(totalCount);

        if (pageBean.getCurrentPage() <= 0) {
            pageBean.setCurrentPage(1);
        } else if (pageBean.getCurrentPage() > pageBean.getTotalPage()) {
            pageBean.setCurrentPage(pageBean.getTotalPage());
        }
        //获取当前页：计算查询的起始行、返回行数
        int currentPage = pageBean.getCurrentPage();
        int index = (currentPage - 1) * pageBean.getPageCount();
        int count = pageBean.getPageCount();
        List<Order> orderList=qr.query(sql.toString(), new BeanListHandler<>(Order.class),shhr);
        pageBean.setList(orderList);


    }

    public int getTotalCountShhr(String shhr) throws SQLException {
        Integer l=null;
        List<Order> orderList=null;
        String sql = "select * from  `order` where shhr like '%' ? '%'";
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
       orderList=qr.query(sql,new BeanListHandler<>(Order.class),shhr);
        l=orderList.size();

        return l.intValue();
    }

    //按商品名称模糊查询订单
    @Override
    public List<Order> selectOrderByShp_mch(String shp_mch) {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select * from  `order` where shp_mch  like '%' ? '%'";
        List<Order> orderList =null;
        try {
            orderList=qr.query(sql.toString(),new BeanListHandler<Order>(Order.class),shp_mch);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public void selectDdByShp(PageBean<Order> pageBean, String shp_mch) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select * from  `order` where shp_mch  like '%' ? '%'";
        List<Order> orderList =null;
        //查询总记录数；  并设置保存到pageBean对象中
        int totalCount = getTotalCountshp_mch(shp_mch);
        pageBean.setTotalCount(totalCount);

        if (pageBean.getCurrentPage() <= 0) {
            pageBean.setCurrentPage(1);
        } else if (pageBean.getCurrentPage() > pageBean.getTotalPage()) {
            pageBean.setCurrentPage(pageBean.getTotalPage());
        }

        //获取当前页：计算查询的起始行、返回行数
        int currentPage = pageBean.getCurrentPage();
        int index = (currentPage - 1) * pageBean.getPageCount();
        int count = pageBean.getPageCount();
        orderList=qr.query(sql.toString(), new BeanListHandler<>(Order.class),shp_mch);
        pageBean.setList(orderList);
    }

    public int getTotalCountshp_mch(String shp_mch) throws SQLException {
        Integer l=null;
        List<Order> orderList=null;
        String sql = "select * from  `order` where shp_mch  like '%' ? '%'";
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        orderList=qr.query(sql,new BeanListHandler<>(Order.class),shp_mch);
        l=orderList.size();
        return l.intValue();
    }

    //查询所有订单
    @Override
    public List<Order> selectAll() throws SQLException {
        String sql = "select * from `order`";
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        List<Order> orderList = qr.query(sql.toString(),new BeanListHandler<Order>(Order.class));
        return orderList;
    }

    @Override
    public List<Order> selectDdAll() throws SQLException {
        String sql = "select * from `order`";
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        List<Order> orderList = qr.query(sql.toString(),new BeanListHandler<Order>(Order.class));
        return orderList;
    }
}
