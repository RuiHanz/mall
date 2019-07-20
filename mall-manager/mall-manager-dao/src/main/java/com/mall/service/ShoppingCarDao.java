package com.mall.service;

import java.sql.SQLException;
import java.util.List;

public interface ShoppingCarDao {
    //查询按id
    public List<ShoppingCar> selectById(String gwc_id) throws SQLException;
    //删除 按id
    public Integer deleteById(String gwc_id) throws SQLException;


}
