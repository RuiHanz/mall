package com.mall.service.comment;

import com.mall.service.Comment.Comment;
import com.mall.service.utils.PageBean;

import java.sql.SQLException;

public interface ICommentDaoPage {
    /* 分页查询数据
     * */
    public  void  getAll(PageBean<Comment> pageBean) throws SQLException;

    /*
     * 查询总记录数
     * */
    public int getTotalCount() throws SQLException;
}
