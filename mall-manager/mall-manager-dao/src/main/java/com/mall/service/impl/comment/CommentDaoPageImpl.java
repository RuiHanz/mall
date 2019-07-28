package com.mall.service.impl.comment;

import com.mall.service.Comment.Comment;
import com.mall.service.comment.ICommentDaoPage;
import com.mall.service.utils.JdbcUtils;
import com.mall.service.utils.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CommentDaoPageImpl implements ICommentDaoPage {
    @Override
    public void getAll(PageBean<Comment> pageBean) throws SQLException {
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
        String sql = "select * from product_comment limit ?,?";

        List<Comment> cList = qr.query(sql, new BeanListHandler<>(Comment.class), index, count);
        pageBean.setList(cList);
    }

    @Override
    public int getTotalCount() throws SQLException {
        Integer l=null;
        List<Comment> cList=null;
        String sql = "select * from product_comment";
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());

       cList=qr.query(sql,new BeanListHandler<>(Comment.class));
        l=cList.size();

        return l.intValue();

    }
}
