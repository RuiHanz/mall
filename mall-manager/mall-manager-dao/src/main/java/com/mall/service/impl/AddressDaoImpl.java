package com.mall.service.impl;

import com.mall.service.AddressDao;
import com.mall.service.address;
import com.mall.service.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AddressDaoImpl implements AddressDao {
    @Override
    public List<address> selectAddressByYh_id(String yh_id) throws SQLException {
        QueryRunner qr=new QueryRunner(JdbcUtils.getDs());
        List<address> addressList= null;
        String sql="select * from secondprogram1.user_address where yh_id = ?";
        addressList=qr.query(sql, new BeanListHandler<>(address.class),yh_id);
        return addressList;
    }
}
