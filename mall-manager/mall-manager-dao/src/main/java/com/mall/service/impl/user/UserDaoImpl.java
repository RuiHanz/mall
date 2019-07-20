package com.mall.service.impl.user;

import com.mall.service.markAndclass.Mark;
import com.mall.service.user.IUserDao;
import com.mall.service.user.User;
import com.mall.service.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl  implements IUserDao {

    @Override
    public List<User> getUsersByid(String yh_id) throws SQLException {

        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select yh_id,yh_mch,yh_mm,yh_xm,yh_shjh,yh_yx,yh_tx,id_card,yh_xb,yh_jg,yh_zht from user_account where yh_id=? ";
        List<User> userlist = null;
        userlist=  qr.query(sql,new BeanListHandler<>(User.class),yh_id);
        return userlist;
    }

    @Override
    public List<User> login(String yh_shjh,String yh_mm) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select * from user_account where yh_shjh= ? and yh_mm = ? ";
        List<User> userlist = null;
        userlist=  qr.query(sql,new BeanListHandler<>(User.class),yh_shjh,yh_mm);

        return userlist;

    }

    @Override
    public void saveSignData(String yh_id, String yh_mch, String yh_mm, String yh_shjh) {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());

        String sql = "INSERT INTO user_account(yh_id,yh_mch,yh_mm,yh_xm,yh_shjh,yh_yx,yh_tx,id_card,yh_xb,yh_jg,yh_zht)"+
                "values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            qr.update(sql,yh_id,yh_mch,yh_mm,null,yh_shjh,null,null,null,null,null,0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> selectAll() {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select yh_id,yh_mch,yh_mm,yh_xm,yh_shjh,yh_yx,yh_tx,id_card,yh_xb,yh_jg,yh_zht from user_account;";
        List<User> userList=null;
        try {
            userList = qr.query(sql.toString(), new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public List<User> selectUserByName(String yh_mch) {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select yh_id,yh_mch,yh_mm,yh_xm,yh_shjh,yh_yx,yh_tx,id_card,yh_xb,yh_jg,yh_zht from user_account where yh_mch=?";
        List<User> userList=null;
        try {
            userList = qr.query(sql.toString(), new BeanListHandler<>(User.class),yh_mch);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public List<User> selectUserByPhone(String yh_shjh) {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select yh_id,yh_mch,yh_mm,yh_xm,yh_shjh,yh_yx,yh_tx,id_card,yh_xb,yh_jg,yh_zht from user_account where yh_shjh=?";
        List<User> userList=null;
        try {
            userList = qr.query(sql.toString(), new BeanListHandler<>(User.class),yh_shjh);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;

    }

    @Override
    public Integer closeUser(String yh_id) {
        QueryRunner qr=new QueryRunner(JdbcUtils.getDs());
        String sql="UPDATE user_account SET yh_zht=1 WHERE yh_id = ?";
        Integer i=0;
        int a=1;
        try {
            i=qr.update(sql,yh_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public Integer openUser(String yh_id) {
        QueryRunner qr=new QueryRunner(JdbcUtils.getDs());
        String sql="UPDATE user_account SET yh_zht=0 WHERE yh_id = ?";
        Integer i=0;

        try {
            i=qr.update(sql,yh_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public Integer deleteUser(String yh_id) {
        QueryRunner qr=new QueryRunner(JdbcUtils.getDs());

        String sql = "delete from user_account where yh_id = ?";
        Integer i=0;
        try {
            i=qr.update(sql,yh_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}
