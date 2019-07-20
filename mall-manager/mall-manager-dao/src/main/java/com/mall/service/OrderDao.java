package com.mall.service;

import java.sql.SQLException;

public interface OrderDao {
    //添加订单
    public Integer addOrder(String gwc_id,String yjsdshj,Integer jdh) throws SQLException;


}
