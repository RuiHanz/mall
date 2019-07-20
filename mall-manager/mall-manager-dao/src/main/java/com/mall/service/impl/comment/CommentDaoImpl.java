package com.mall.service.impl.comment;


import com.mall.service.Comment.Comment;
import com.mall.service.comment.ICommentDao;
import com.mall.service.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CommentDaoImpl implements ICommentDao {
    @Override
    public List<Comment> getCommentUser(String yh_id) throws SQLException{
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select * from product_comment where yh_id = ?";

        List<Comment> cList = qr.query(sql,new BeanListHandler<>(Comment.class),yh_id);
        return cList;
    }

    @Override
    public List<Comment> getCommentPro(String shp_id) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select * from product_comment where yh_id = ?";

        List<Comment> cList = qr.query(sql,new BeanListHandler<>(Comment.class),shp_id);
        return cList;

    }

    @Override
    public List<Comment> selectByShp_mch(String shp_mch) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select * from product_comment where shp_mch= ?";

        List<Comment> cList = qr.query(sql,new BeanListHandler<>(Comment.class),shp_mch);
        return cList;
    }

    @Override
    public void addComment(Comment comment) {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "insert into product_comment (pl_id,yh_id,plnr,plshj,hpjb,shp_mch,dd_id,shp_id) values (?,?,?,?,?,?,?,?)";
        try {
            //qr.insert(sql,new BeanHandler<>(Comment.class));
            qr.execute(sql,new BeanHandler<>(Comment.class),comment.getPl_id(),comment.getYh_id(),comment.getPlnr(),comment.getPlshj(),comment.getHpjb(),comment.getShp_mch(),comment.getDd_id(),comment.getShp_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void delComment(String dd_id) {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "delete from product_comment where dd_id = ?";
        try {
            qr.execute(sql,dd_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Comment> sellectAll() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql="select pl_id,yh_id,plnr,plshj,hpjb,shp_mch,dd_id,shp_id from product_comment;";
        List<Comment> cList=qr.query(sql,new BeanListHandler<>(Comment.class));
        return cList;
    }

//    @Override
//    public void updateComment(String dd_id) {
//        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
//        String sql =  "update set plnr = ? where dd_id = ?";
//        try {
//            qr.update(sql,dd_id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
