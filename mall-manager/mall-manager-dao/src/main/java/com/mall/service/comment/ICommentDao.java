package com.mall.service.comment;

import com.mall.service.Comment.Comment;
import com.mall.service.utils.PageBean;

import java.sql.SQLException;
import java.util.List;

public interface ICommentDao {
    //查询所有评论
    public List<Comment> sellectAll() throws SQLException;
    //查询个人评论
    public List<Comment> getCommentUser(String yh_id) throws SQLException;
    public void selectByYh_id(PageBean<Comment> pageBean, String yh_id) throws SQLException;
    //查询商品评论
    public List<Comment> getCommentPro(String shp_id) throws SQLException;
    public void selectByShp_id(PageBean<Comment> pageBean, String shp_id) throws SQLException;
    //查询商品评论按商品名称
    public List<Comment> selectByShp_mch(String shp_mch) throws SQLException;
    public void selectByShp_mch(PageBean<Comment> pageBean, String shp_mch) throws SQLException;
    //删除评论
    public void delComment(String pl_id);
    /*//添加评论
    public void addComment(Comment comment);*/





}
