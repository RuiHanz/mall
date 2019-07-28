package com.mall.service.impl.markAndclass.dao.impl;

import com.mall.service.markAndclass.Mark;
import com.mall.service.markAndclass.MarkDao;
import com.mall.service.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class MarkDaoImpl implements MarkDao {

    @Override
    public Integer addMark(Mark mark) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql="INSERT INTO mark (pp_id,ppmch,url,flmch1_id) " +
                "VALUES(?,?,?,0);";
        qr.update(sql,mark.getPp_id(),mark.getPpmch(),mark.getUrl());
        return 1;
    }

    @Override
    public Mark selectMarkIdByName(String ppmch) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select pp_id from mark where ppmch=?";
        Mark mark =  qr.query(sql,new BeanHandler<>(Mark.class),ppmch);
        return mark;


    }

    @Override
    public List<Mark> selectMarkById(String pp_id) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql="select pp_id,ppmch,url from mark where pp_id=?";
        List<Mark> mark=qr.query(sql,new BeanListHandler<>(Mark.class),pp_id);
        return mark;

    }

    @Override
    public Mark selectMarkNameById(String pp_id) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql="select ppmch from mark where pp_id=?";
        Mark mark=qr.query(sql,new BeanHandler<>(Mark.class),pp_id);
        return mark;

    }

    @Override
    public List<Mark> selectMarkByName(String ppmch) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql="select pp_id,ppmch,url from mark where ppmch=?";
        List<Mark> mark=qr.query(sql,new BeanListHandler<>(Mark.class),ppmch);
        return mark;
    }

    @Override
    public List<Mark> selectAll() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "SELECT * FROM mark;";
        List<Mark> markList=null;
        markList=qr.query(sql.toString(),new BeanListHandler<>(Mark.class));
        return markList;
    }

    @Override
    public Integer deleteMarkById(String pp_id) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "delete from mark where pp_id=?";
        qr.update(sql,pp_id);
        return 1;

    }

    @Override
    public Integer updateMarkById(Mark mark, String pp_id) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql="UPDATE mark SET pp_id=?,ppmch=?,url=?,flmch1_id=0" +
                " WHERE pp_id=?;";
        qr.update(sql,mark.getPp_id(),mark.getPpmch(),mark.getUrl(),pp_id);
        return 1;
    }
}
