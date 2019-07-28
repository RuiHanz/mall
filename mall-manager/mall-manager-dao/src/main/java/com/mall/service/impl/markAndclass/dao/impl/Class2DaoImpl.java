package com.mall.service.impl.markAndclass.dao.impl;

import com.mall.service.markAndclass.Class2;
import com.mall.service.markAndclass.IClass2Dao;
import com.mall.service.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class Class2DaoImpl implements IClass2Dao {
    @Override
    public Class2 selectById(Integer flmch2_id) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql="select flmch2 from class_2 where flmch2_id=?";
        Class2 class2=qr.query(sql,new BeanHandler<>(Class2.class),flmch2_id);
        return class2;
    }

    @Override
    public Class2 selectIdByName(String flmch2) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql="select flmch2_id from class_2 where flmch2=?";
        Class2 class2=qr.query(sql,new BeanHandler<>(Class2.class),flmch2);
        return class2;

    }
}
