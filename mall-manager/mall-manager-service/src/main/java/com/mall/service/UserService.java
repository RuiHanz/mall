package com.mall.service;

import com.mall.service.user.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    //查询，按用户id
    public List<User> getUsersByidService(String yh_id) throws SQLException;

    //将获取到的信息存入数据库(注册)
    public void saveSignDataService(String yh_id,String yh_mch, String yh_mm, String yh_shjh);

    //查询用户按用户名与密码（登录）
    public List<User> login(String yh_shjh,String yh_mm) throws SQLException;

    //查询所有
    public List<User> selectAllService();

    //查询（按用户名）
    public List<User> selectUserByNameService(String yh_mch);

    //查询（按用户手机号）
    public List<User> selectUserByPhoneService(String yh_shjh);

    //更改用户状态(封号) 按id
    public Integer closeUserService(String yh_id);

    //解除封禁
    public Integer openUserService(String yh_id);

    //删除用户
    public Integer deleteUserService(String yh_id);
}
