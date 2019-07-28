package com.mall.service.impl;

import com.mall.service.Comment.Comment;
import com.mall.service.ICommentService;
import com.mall.service.comment.ICommentDao;
import com.mall.service.comment.ICommentDaoPage;
import com.mall.service.impl.comment.CommentDaoImpl;
import com.mall.service.impl.comment.CommentDaoPageImpl;
import com.mall.service.utils.PageBean;

import java.sql.SQLException;
import java.util.List;

public class CommentServiceImpl implements ICommentService {
    @Override
    public boolean deleteCommentService(String pl_id) {
        ICommentDao dao =new CommentDaoImpl();
        dao.delComment(pl_id);
        return false;
    }

    @Override
    public List<Comment> selectAllService() throws SQLException {
        ICommentDao dao =new CommentDaoImpl();
        List<Comment> cList =null;
        cList =dao.sellectAll();
        return cList;
    }

    @Override
    public List<Comment> selectByYh_idService(String yh_id) throws SQLException {
        ICommentDao dao =new CommentDaoImpl();
        List<Comment> cList =null;
        cList =dao.getCommentUser(yh_id);
        return cList;
    }

    @Override
    public void selectByYh_id1Service(PageBean<Comment> pageBean, String yh_id) throws SQLException {
        ICommentDao dao =new CommentDaoImpl();
        dao.selectByYh_id(pageBean, yh_id);
    }

    @Override
    public List<Comment> selectByShp_idService(String shp_id) throws SQLException {
        ICommentDao dao =new CommentDaoImpl();
        List<Comment> cList =null;
        cList =dao.getCommentPro(shp_id);
        return cList;
    }

    @Override
    public void selectByShp_id1Service(PageBean<Comment> pageBean, String shp_id) throws SQLException {
        ICommentDao dao =new CommentDaoImpl();
        dao.selectByShp_id(pageBean, shp_id);
    }

    @Override
    public List<Comment> selectByShp_mchService(String shp_mch) throws SQLException {
        ICommentDao dao =new CommentDaoImpl();
        List<Comment> cList =null;
        cList =dao.selectByShp_mch(shp_mch);
        return cList;
    }

    @Override
    public void selectByShp_mchService(PageBean<Comment> pageBean, String shp_mch) throws SQLException {
        ICommentDao dao =new CommentDaoImpl();
        dao.selectByShp_mch(pageBean, shp_mch);
    }

    @Override
    public void getAllService(PageBean<Comment> pageBean) throws SQLException {
        ICommentDaoPage dao =new CommentDaoPageImpl();
        dao.getAll(pageBean);
    }
}
