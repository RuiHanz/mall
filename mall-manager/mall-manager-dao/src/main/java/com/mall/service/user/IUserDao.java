package com.mall.service.user;


import java.sql.SQLException;
import java.util.List;


public interface IUserDao {
    //查询，按用户id
    public List<User> getUsersByid(String yh_id) throws SQLException;

    //查询用户按手机号与密码（登录）
    public List<User> login(String yh_shjh,String yh_mm) throws SQLException;

    //将获取到的信息存入数据库(注册)
    public void saveSignData(String yh_id,String yh_mch, String yh_mm, String yh_shjh);

    //查询所有
    public List<User> selectAll();

    //查询（按用户名）
    public List<User> selectUserByName(String yh_mch);

    //查询（按用户手机号）
    public List<User> selectUserByPhone(String yh_shjh);

    //更改用户状态(封号) 按id
    public Integer closeUser(String yh_id);

    //解除封禁
    public Integer openUser(String yh_id);

    //删除用户
    public Integer deleteUser(String yh_id);



}
