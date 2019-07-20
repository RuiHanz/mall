package com.mall.service;

import java.sql.SQLException;
import java.util.List;

public interface AddressDao {
    //查询用户地址按用户id
    public List<address> selectAddressByYh_id(String yh_id) throws SQLException;
}
