package com.mall.service.product;

import com.mall.service.utils.PageBean;

import java.sql.SQLException;

public interface IProductDao {

     /* 分页查询数据
     * */
    public  void  getAll(PageBean<Product1> pageBean) throws SQLException;

    /*
     * 查询总记录数
     * */
    public int getTotalCount() throws SQLException;
}
