package com.mall.service.user;

import com.mall.service.utils.PageBean;

import java.sql.SQLException;

public interface UserDao {
    /* 分页查询数据
     * */
    public  void  getAll(PageBean<User> pageBean) throws SQLException;

    /*
     * 查询总记录数
     * */
    public int getTotalCount() throws SQLException;

    //查询 按名称
    public void getByYh_mch(PageBean<User> pageBean,String yh_mch) throws SQLException;
    //查询 按手机号
    public void getByYh_shjh(PageBean<User> pageBean,String yh_shjh) throws SQLException;
}
