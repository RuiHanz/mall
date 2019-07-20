package com.mall.service.impl;

import com.mall.service.ShoppingCar;
import com.mall.service.ShoppingCarDao;
import com.mall.service.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ShoppingCarDaoImpl implements ShoppingCarDao {
    @Override
    public List<ShoppingCar> selectById(String gwc_id) throws SQLException {
        QueryRunner qr=new QueryRunner(JdbcUtils.getDs());
        List<ShoppingCar> shoppingCarList= null;
        String sql="select * from secondprogram1.shoppingcar_info where gwc_id = ?";
        shoppingCarList=qr.query(sql, new BeanListHandler<>(ShoppingCar.class),gwc_id);
        return shoppingCarList;

    }

    @Override
    public Integer deleteById(String gwc_id) throws SQLException {
        QueryRunner qr=new QueryRunner(JdbcUtils.getDs());
        String sql="delete from secondprogram1.shoppingcar_info where gwc_id = ?";
        qr.update(sql,gwc_id);
        return 1;

    }
}
