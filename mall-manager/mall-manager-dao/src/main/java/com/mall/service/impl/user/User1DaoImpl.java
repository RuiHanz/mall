package com.mall.service.impl.user;

import com.mall.service.user.User;
import com.mall.service.user.UserDao;
import com.mall.service.utils.JdbcUtils;
import com.mall.service.utils.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class User1DaoImpl implements UserDao {
    @Override
    public void getAll(PageBean<User> pageBean) throws SQLException {
        //查询总记录数；  并设置保存到pageBean对象中
        int totalCount = getTotalCount();
        pageBean.setTotalCount(totalCount);
        if (pageBean.getCurrentPage() <= 0) {
            pageBean.setCurrentPage(1);
        } else if (pageBean.getCurrentPage() > pageBean.getTotalPage()) {
            pageBean.setCurrentPage(pageBean.getTotalPage());
        }
        //获取当前页：计算查询的起始行、返回行数
        int currentPage = pageBean.getCurrentPage();
        int index = (currentPage - 1) * pageBean.getPageCount();
        int count = pageBean.getPageCount();
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select yh_id,yh_mch,yh_mm,yh_xm,yh_shjh,yh_yx,yh_tx,id_card,yh_xb,yh_jg,yh_zht from user_account limit ?,?";
        List<User> userList = qr.query(sql,new BeanListHandler<>(User.class),index,count);
        pageBean.setList(userList);
    }

    @Override
    public int getTotalCount() throws SQLException {
        Integer l=null;
        List<User> userList = null;
        String sql = "select yh_id,yh_mch,yh_mm,yh_xm,yh_shjh,yh_yx,yh_tx,id_card,yh_xb,yh_jg,yh_zht from user_account";
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        userList = qr.query(sql,new BeanListHandler<>(User.class));
        l=userList.size();
        return l.intValue();
    }
    public int getTotalCountYh_mch(String yh_mch) throws SQLException {
        Integer l=null;
        List<User> userList = null;
        String sql = "select yh_id,yh_mch,yh_mm,yh_xm,yh_shjh,yh_yx,yh_tx,id_card,yh_xb,yh_jg,yh_zht from user_account where yh_mch=?";
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        userList = qr.query(sql,new BeanListHandler<>(User.class),yh_mch);
        l=userList.size();
        return l.intValue();
    }
    public int getTotalCountYh_shjh(String yh_shjh) throws SQLException {
        Integer l=null;
        List<User> userList = null;
        String sql = "select yh_id,yh_mch,yh_mm,yh_xm,yh_shjh,yh_yx,yh_tx,id_card,yh_xb,yh_jg,yh_zht from user_account where yh_shjh=?";
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        userList = qr.query(sql,new BeanListHandler<>(User.class),yh_shjh);
        l=userList.size();
        return l.intValue();
    }

    @Override
    public void getByYh_mch(PageBean<User> pageBean, String yh_mch) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select yh_id,yh_mch,yh_mm,yh_xm,yh_shjh,yh_yx,yh_tx,id_card,yh_xb,yh_jg,yh_zht from user_account where yh_mch=?";
        int totalCount = getTotalCountYh_mch(yh_mch);
        pageBean.setTotalCount(totalCount);
        if (pageBean.getCurrentPage() <= 0) {
            pageBean.setCurrentPage(1);
        } else if (pageBean.getCurrentPage() > pageBean.getTotalPage()) {
            pageBean.setCurrentPage(pageBean.getTotalPage());
        }
        int currentPage = pageBean.getCurrentPage();
        int index = (currentPage - 1) * pageBean.getPageCount();
        int count = pageBean.getPageCount();
        List<User> userList = qr.query(sql,new BeanListHandler<>(User.class),yh_mch);
        pageBean.setList(userList);

    }

    @Override
    public void getByYh_shjh(PageBean<User> pageBean, String yh_shjh) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select yh_id,yh_mch,yh_mm,yh_xm,yh_shjh,yh_yx,yh_tx,id_card,yh_xb,yh_jg,yh_zht from user_account where yh_shjh=?";
        List<User> userList=null;
        int totalCount = getTotalCountYh_shjh(yh_shjh);
        pageBean.setTotalCount(totalCount);
        if (pageBean.getCurrentPage() <= 0) {
            pageBean.setCurrentPage(1);
        } else if (pageBean.getCurrentPage() > pageBean.getTotalPage()) {
            pageBean.setCurrentPage(pageBean.getTotalPage());
        }
        int currentPage = pageBean.getCurrentPage();
        int index = (currentPage - 1) * pageBean.getPageCount();
        int count = pageBean.getPageCount();
        userList = qr.query(sql.toString(), new BeanListHandler<>(User.class),yh_shjh);
        pageBean.setList(userList);

    }

}
