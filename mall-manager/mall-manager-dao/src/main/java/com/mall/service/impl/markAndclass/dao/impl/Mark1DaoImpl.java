package com.mall.service.impl.markAndclass.dao.impl;

import com.mall.service.markAndclass.IMarkDao;
import com.mall.service.markAndclass.Mark;
import com.mall.service.user.User;
import com.mall.service.utils.JdbcUtils;
import com.mall.service.utils.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Mark1DaoImpl implements IMarkDao {
    @Override
    public void getAll(PageBean<Mark> pageBean) throws SQLException {
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
        String sql = "SELECT * FROM mark limit ?,?";
        List<Mark> markList = qr.query(sql,new BeanListHandler<>(Mark.class),index,count);
        pageBean.setList(markList);
    }

    @Override
    public int getTotalCount() throws SQLException {
        Integer l=null;
        List<Mark> markList = null;
        String sql = "SELECT * FROM mark";
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        markList = qr.query(sql,new BeanListHandler<>(Mark.class));
        l=markList.size();

        return l.intValue();
    }

    @Override
    public void getByPpmch(PageBean<Mark> pageBean,String ppmch) throws SQLException {

        int totalCount = 1;
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
        String sql="select pp_id,ppmch,url from mark where ppmch=?";
        List<Mark> mark=qr.query(sql,new BeanListHandler<>(Mark.class),ppmch);
        pageBean.setList(mark);
    }
}
