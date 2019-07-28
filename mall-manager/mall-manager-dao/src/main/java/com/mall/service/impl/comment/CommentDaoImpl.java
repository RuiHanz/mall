package com.mall.service.impl.comment;


import com.mall.service.Comment.Comment;
import com.mall.service.comment.ICommentDao;
import com.mall.service.utils.JdbcUtils;
import com.mall.service.utils.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CommentDaoImpl implements ICommentDao {
    @Override
    public List<Comment> getCommentUser(String yh_id) throws SQLException{
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select * from product_comment where yh_id = ?";

        List<Comment> cList = qr.query(sql,new BeanListHandler<>(Comment.class),yh_id);
        return cList;
    }

    @Override
    public void selectByYh_id(PageBean<Comment> pageBean, String yh_id) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql="select * from product_comment where yh_id = ?";
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
        List<Comment> cList=qr.query(sql.toString(), new BeanListHandler<>(Comment.class),yh_id);
        pageBean.setList(cList);
    }

    @Override
    public List<Comment> getCommentPro(String shp_id) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select * from product_comment where shp_id = ?";
        List<Comment> cList = qr.query(sql,new BeanListHandler<>(Comment.class),shp_id);
        return cList;
    }

    @Override
    public void selectByShp_id(PageBean<Comment> pageBean, String shp_id) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql="select * from product_comment where shp_id = ?";
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
        List<Comment> cList=qr.query(sql.toString(), new BeanListHandler<>(Comment.class),shp_id);
        pageBean.setList(cList);
    }

    @Override
    public List<Comment> selectByShp_mch(String shp_mch) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select * from product_comment where shp_mch= ?";

        List<Comment> cList = qr.query(sql,new BeanListHandler<>(Comment.class),shp_mch);
        return cList;
    }

    @Override
    public void selectByShp_mch(PageBean<Comment> pageBean, String shp_mch) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql="select * from product_comment where shp_mch= ?";
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
        List<Comment> cList=qr.query(sql.toString(), new BeanListHandler<>(Comment.class),shp_mch);
        pageBean.setList(cList);
    }


    @Override
    public void delComment(String pl_id) {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "delete from product_comment where pl_id = ?";
        try {
            qr.execute(sql,pl_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Comment> sellectAll() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql="select * from product_comment";
        List<Comment> cList=qr.query(sql,new BeanListHandler<>(Comment.class));
        return cList;
    }

//    @Override
//    public void updateComment(String dd_id) {
//        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
//        String sql =  "update set plnr = ? where dd_id = ?";
//        try {
//            qr.update(sql,dd_id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
