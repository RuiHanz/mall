package com.mall.service.markAndclass;

import com.mall.service.product.Product1;
import com.mall.service.utils.PageBean;

import java.sql.SQLException;

public interface IMarkDao {
    /* 分页查询数据
     * */
    public  void  getAll(PageBean<Mark> pageBean) throws SQLException;

    /*
     * 查询总记录数
     * */
    public int getTotalCount() throws SQLException;

    public void getByPpmch(PageBean<Mark> pageBean,String ppmch) throws SQLException;
}
