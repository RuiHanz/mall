package com.mall.service.impl.order;


import com.mall.service.order.IOrderDaoPage;
import com.mall.service.order.Order;
import com.mall.service.utils.JdbcUtils;
import com.mall.service.utils.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class OrderDaoPageImpl implements IOrderDaoPage {
    @Override
    public void getAll(PageBean<Order> pageBean) throws SQLException {
        //查询总记录数；  并设置保存到pageBean对象中
        int totalCount = getTotalCount();
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

        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql="select * from  `order` limit ?,?";
        List<Order> orderList = qr.query(sql, new BeanListHandler<Order>(Order.class), index, count);
        pageBean.setList(orderList);
    }

    @Override
    public int getTotalCount() throws SQLException {
        Integer l=null;
        List<Order> orderList=null;
        String sql="select * from  `order`";
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        orderList=qr.query(sql,new BeanListHandler<>(Order.class));
        l=orderList.size();

        return l.intValue();

    }
}
