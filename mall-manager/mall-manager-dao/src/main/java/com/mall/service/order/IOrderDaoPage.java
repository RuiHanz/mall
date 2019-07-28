package com.mall.service.order;


import com.mall.service.utils.PageBean;

import java.sql.SQLException;

public interface IOrderDaoPage {
    /* 分页查询数据
     * */
    public  void  getAll(PageBean<Order> pageBean) throws SQLException;

    /*
     * 查询总记录数
     * */
    public int getTotalCount() throws SQLException;
}
