package com.mall.service;

import com.mall.service.Comment.Comment;
import com.mall.service.utils.PageBean;

import java.sql.SQLException;
import java.util.List;

public interface ICommentService {
    //删除商品 按id
    public boolean deleteCommentService(String pl_id);
    //查询所有
    public List<Comment> selectAllService() throws SQLException;
    //查询，按用户id
    public List<Comment> selectByYh_idService(String yh_id) throws SQLException;
    public void selectByYh_id1Service(PageBean<Comment> pageBean, String yh_id) throws SQLException;
    //查询,按商品id模糊查询
    public List<Comment> selectByShp_idService(String shp_id) throws SQLException;
    public void selectByShp_id1Service(PageBean<Comment> pageBean, String shp_id) throws SQLException;

    //查询，按商品名称
    public List<Comment> selectByShp_mchService(String shp_mch) throws SQLException;
    public void selectByShp_mchService(PageBean<Comment> pageBean, String shp_mch) throws SQLException;

    /* 分页查询数据
     * */
    public  void  getAllService(PageBean<Comment> pageBean) throws SQLException;


}
