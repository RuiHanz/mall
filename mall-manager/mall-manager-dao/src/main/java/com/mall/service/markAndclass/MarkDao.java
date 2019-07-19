package com.mall.service.markAndclass;

import java.sql.SQLException;
import java.util.List;

public interface MarkDao {
    //增加品牌
    public Integer addMark(Mark mark) throws SQLException;

    //查询商标id
    public Mark selectMarkIdByName(String ppmch) throws SQLException;

    //查询品牌按id
    public List<Mark> selectMarkById(String pp_id) throws SQLException;
    //查询品牌按名称
    public List<Mark> selectMarkByName(String ppmch) throws SQLException;

    //查询所有
    public List<Mark> selectAll() throws SQLException;

    //删除品牌 按id
    public Integer deleteMarkById(String pp_id) throws SQLException;

    //修改品牌 按id
    public Integer updateMarkById(Mark mark,String pp_id) throws SQLException;


}
