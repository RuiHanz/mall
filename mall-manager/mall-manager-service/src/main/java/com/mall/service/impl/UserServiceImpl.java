package com.mall.service.impl;

import com.mall.service.UserService;
import com.mall.service.impl.user.User1DaoImpl;
import com.mall.service.impl.user.UserDaoImpl;
import com.mall.service.user.IUserDao;
import com.mall.service.user.User;
import com.mall.service.user.UserDao;
import com.mall.service.utils.PageBean;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<User> getUsersByidService(String yh_id) throws SQLException {
        List<User> userList=null;
        IUserDao userDao=new UserDaoImpl();
        userList=userDao.getUsersByid(yh_id);
        return userList;

    }

    @Override
    public void saveSignDataService(String yh_id, String yh_mch, String yh_mm, String yh_shjh) {

    }

    @Override
    public List<User> login(String yh_shjh, String yh_mm) throws SQLException {
        List<User> userList=null;
        IUserDao userDao=new UserDaoImpl();
        userList=userDao.login(yh_shjh,yh_mm);
        return userList;
    }

    @Override
    public List<User> selectAllService() {
        List<User> userList=null;
        IUserDao dao=new UserDaoImpl();
        userList=dao.selectAll();
        return userList;

    }

    @Override
    public List<User> selectUserByNameService(String yh_mch) {
        List<User> userList=null;
        IUserDao dao=new UserDaoImpl();
        userList=dao.selectUserByName(yh_mch);
        return  userList;
    }

    @Override
    public List<User> selectUserByPhoneService(String yh_shjh) {
        List<User> userList=null;
        IUserDao dao=new UserDaoImpl();
        userList=dao.selectUserByPhone(yh_shjh);
        return userList;
    }

    @Override
    public Integer closeUserService(String yh_id) {
        IUserDao dao=new UserDaoImpl();
        Integer i=0;
        i=dao.closeUser(yh_id);
        return i;
    }

    @Override
    public Integer openUserService(String yh_id) {
        IUserDao dao=new UserDaoImpl();
        Integer i=0;
        i=dao.openUser(yh_id);
        return i;
    }

    @Override
    public Integer deleteUserService(String yh_id) {
        IUserDao dao=new UserDaoImpl();
        Integer i=0;
        i=dao.deleteUser(yh_id);
        return i;
    }

    @Override
    public void getAllService(PageBean<User> pageBean) throws SQLException {
        UserDao dao = new User1DaoImpl();
        dao.getAll(pageBean);
    }

    @Override
    public void getByYh_mchService(PageBean<User> pageBean, String yh_mch) throws SQLException {
        UserDao dao = new User1DaoImpl();
        dao.getByYh_mch(pageBean,yh_mch);
    }

    @Override
    public void getByYh_shjhService(PageBean<User> pageBean, String yh_shjh) throws SQLException {
        UserDao dao = new User1DaoImpl();
        dao.getByYh_shjh(pageBean,yh_shjh);
    }


}
