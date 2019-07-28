package com.mall.service;

import com.mall.service.markAndclass.Mark;
import com.mall.service.user.User;
import com.mall.service.utils.PageBean;

import java.sql.SQLException;
import java.util.List;

public interface MarkService {
    //查询商标
    public Mark selectMarkIdByNameService(String ppmch) throws SQLException;
    //添加品牌
    public Integer addMarkService(Mark mark) throws SQLException;
    //删除品牌 按id
    public Integer deleteMarkByIdService(String pp_id) throws SQLException;

    //修改品牌 按id
    public Integer updateMarkByIdService(Mark mark,String pp_id) throws SQLException;
    //查询所有
    public List<Mark> selectAllService() throws SQLException;
    //查询品牌按id
    public List<Mark> selectMarkByIdService(String pp_id) throws SQLException;
    public Mark selectMarkNameByIdService(String pp_id) throws SQLException;
    //查询品牌按名称
    public List<Mark> selectMarkByNameService(String ppmch) throws SQLException;
    /* 分页查询数据
     * */
    public  void  getAllService(PageBean<Mark> pageBean) throws SQLException;

    public void getByPpmchService(PageBean<Mark> pageBean,String ppmch) throws SQLException;
}
