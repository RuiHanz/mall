package com.mall.service.markAndclass;

import java.sql.SQLException;

public interface IClass2Dao {
    //根据id查名称
    public Class2 selectById(Integer flmch2_id) throws SQLException;
    //根据名称查id
    public Class2 selectIdByName(String flmch2) throws SQLException;

}
