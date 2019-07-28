package com.mall.service.impl.product;

import com.mall.service.impl.markAndclass.dao.impl.Class2DaoImpl;
import com.mall.service.impl.markAndclass.dao.impl.MarkDaoImpl;
import com.mall.service.markAndclass.Class2;
import com.mall.service.markAndclass.IClass2Dao;
import com.mall.service.markAndclass.Mark;
import com.mall.service.markAndclass.MarkDao;
import com.mall.service.product.Product;
import com.mall.service.product.Product1;
import com.mall.service.product.ProductDao;
import com.mall.service.product.ProductImages;
import com.mall.service.utils.JdbcUtils;
import com.mall.service.utils.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {


    @Override
    public void addProduct(String shp_id, String shp_mch, Integer flmch1_id, Integer flmch2_id, String pp_id, String chjshj, String shp_msh, float shp_jg, String shp_ys, Integer shp_kc,String shp_zht) {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "insert into product(shp_id,shp_mch,flmch1_id,flmch2_id,pp_id,chjshj,shp_msh,shp_jg,shp_ys,shp_kc,shp_zht)" +
                "                value(?,?,?,?,?,date_format(CURRENT_TIMESTAMP,'%Y-%c-%d'),?,?,?,?,?);";
        try {

            qr.update(sql,shp_id,shp_mch,flmch1_id,flmch2_id,pp_id,shp_msh,shp_jg,shp_ys,shp_kc,shp_zht);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> selectAll() {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select * from product";
        List<Product> productList=null;
        try {
            productList = qr.query(sql.toString(), new BeanListHandler<Product>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;

    }

    @Override
    public List<Product1> selectAll1() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql="select shp_id,shp_mch,flmch2,ppmch,chjshj,shp_msh,shp_jg,shp_ys,shp_kc,shp_zht\n" +
                "from product p,class_2 c,mark m where p.pp_id=m.pp_id and p.flmch2_id=c.flmch2_id";

        List<Product1> product1List=qr.query(sql,new BeanListHandler<>(Product1.class));
        return product1List;

    }

    @Override
    public List<Product> selectByName(String shp_mch) {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select * from product where shp_mch=?";
        List<Product> productList=null;
        try {
            productList = qr.query(sql.toString(), new BeanListHandler<Product>(Product.class),shp_mch);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public void selectByName1(PageBean<Product1> pageBean,String shp_mch) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql="select shp_id,shp_mch,flmch2,ppmch,chjshj,shp_msh,shp_jg,shp_ys,shp_kc,shp_zht\n" +
                "from product p,class_2 c,mark m where p.pp_id=m.pp_id and p.flmch2_id=c.flmch2_id and shp_mch=?";
        List<Product1> product1List=null;
        //查询总记录数；  并设置保存到pageBean对象中
        int totalCount = getTotalCountshp_mch(shp_mch);
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
        product1List=qr.query(sql.toString(), new BeanListHandler<>(Product1.class),shp_mch);
        pageBean.setList(product1List);


    }

    @Override
    public List<Product> selectByShp_msh(String shp_msh) {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select * from product where shp_msh like '%' ? '%'";


        List<Product> productList=null;

        try {
            productList = qr.query(sql.toString(), new BeanListHandler<Product>(Product.class),shp_msh);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;

    }

    @Override
    public void selectByShp_msh1(PageBean<Product1> pageBean,String shp_msh) throws SQLException {
        String sql="select shp_id,shp_mch,flmch2,ppmch,chjshj,shp_msh,shp_jg,shp_ys,shp_kc,shp_zht\n" +
                "from product p,class_2 c,mark m where p.pp_id=m.pp_id and p.flmch2_id=c.flmch2_id and shp_msh like '%' ? '%'";
        //查询总记录数；  并设置保存到pageBean对象中
        int totalCount = getTotalCountShp_msh(shp_msh);
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

        List<Product1> product1List=qr.query(sql.toString(), new BeanListHandler<>(Product1.class),shp_msh);
        pageBean.setList(product1List);

    }

    @Override
    public List<Product> selectByShp_id(String shp_id) {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select * from product where shp_id=?";
        List<Product> productList=null;
        try {
            productList = qr.query(sql.toString(), new BeanListHandler<Product>(Product.class),shp_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public void selectByShp_id1(PageBean<Product1> pageBean,String shp_id) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql="select shp_id,shp_mch,flmch2,ppmch,chjshj,shp_msh,shp_jg,shp_ys,shp_kc,shp_zht\n" +
                "from product p,class_2 c,mark m where p.pp_id=m.pp_id and p.flmch2_id=c.flmch2_id and shp_id=?";
        //查询总记录数；  并设置保存到pageBean对象中
        int totalCount =1;
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



        List<Product1> product1List=qr.query(sql.toString(), new BeanListHandler<>(Product1.class),shp_id);
        pageBean.setList(product1List);
    }
    public List<Product1> selectByShp_id2(String shp_id) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select shp_id,shp_mch,flmch2,ppmch,chjshj,shp_msh,shp_jg,shp_ys,shp_kc,shp_zht\n" +
                "from product p,class_2 c,mark m where p.pp_id=m.pp_id and p.flmch2_id=c.flmch2_id and shp_id=?";
        List<Product1> product1List=qr.query(sql,new BeanListHandler<>(Product1.class),shp_id);
        return product1List;


    }

    @Override
    public Product selectStaticByShp_id(String shp_id) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql="select shp_zht from product where shp_id=?";
        Product product=qr.query(sql,new BeanHandler<>(Product.class),shp_id);
        return product;
    }

    @Override
    public void deleteProduct(String shp_id) {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "delete from product where shp_id=?";
        try {
            qr.update(sql, shp_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void updateProduct(Product product,String id) {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql="UPDATE product SET shp_id=?,shp_mch=?,flmch1_id=?,flmch2_id=?,pp_id=?,chjshj=date_format(CURRENT_TIMESTAMP,'%Y-%c-%d'),shp_msh=?,shp_jg=?,shp_ys=?,shp_kc=?" +
                " WHERE shp_id=?;";
        try {
            qr.update(sql,product.getShp_id(),product.getShp_mch(),product.getFlmch1_id(),product.getFlmch2_id(),product.getPp_id(),product.getShp_msh(),product.getShp_jg(),product.getShp_ys(),product.getShp_kc(),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProduct1(Product1 product1, String id) throws SQLException {
        String pp_id=null;
        Integer flmch2_id=null;
        Mark mark=new Mark();
        MarkDao dao = new MarkDaoImpl();
        mark=dao.selectMarkIdByName(product1.getPpmch());
        pp_id=mark.getPp_id();
        Class2 class2=new Class2();
        IClass2Dao class2Dao=new Class2DaoImpl();
        class2=class2Dao.selectIdByName(product1.getFlmch2());
        flmch2_id=class2.getFlmch2_id();
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql="UPDATE product SET shp_id=?,shp_mch=?,flmch2_id=?,pp_id=?,chjshj=date_format(CURRENT_TIMESTAMP,'%Y-%c-%d'),shp_jg=?,shp_kc=?" +
                " WHERE shp_id=?;";
        qr.update(sql,product1.getShp_id(),product1.getShp_mch(),flmch2_id,pp_id,product1.getShp_jg(),product1.getShp_kc(),id);

    }

    @Override
    public void changeProduct(String shp_id) {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql="UPDATE product SET shp_zht='下架'  WHERE shp_id=?;";
        try {
            qr.update(sql,shp_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void changeProduct1(String shp_id) {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql="UPDATE product SET shp_zht='上架'  WHERE shp_id=?;";
        try {
            qr.update(sql,shp_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer addProductImage(ProductImages productImages,String shp_id) {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql="insert into product_image(tu_id,tu_mch,zy,shp_id,url)" +
        "value(?,?,?,?,?);";
        try {
            qr.update(sql,productImages.getTu_Id(),productImages.getTu_mch(),productImages.getZy(),shp_id,productImages.getUrl());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }
    public int getTotalCount(String sql) throws SQLException {
        Integer l=null;
        List<Product1> product1List=null;
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        product1List=qr.query(sql,new BeanListHandler<>(Product1.class));
        l=product1List.size();

        return l.intValue();

    }
    public int getTotalCountShp_msh(String shp_msh) throws SQLException {
        Integer l=null;
        List<Product1> product1List=null;
        String sql="select shp_id,shp_mch,flmch2,ppmch,chjshj,shp_msh,shp_jg,shp_ys,shp_kc,shp_zht\n" +
                "from product p,class_2 c,mark m where p.pp_id=m.pp_id and p.flmch2_id=c.flmch2_id and shp_msh like '%' ? '%'";
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        product1List=qr.query(sql,new BeanListHandler<>(Product1.class),shp_msh);
        l=product1List.size();

        return l.intValue();

    }
    public int getTotalCountshp_mch(String shp_mch) throws SQLException {
        Integer l=null;
        List<Product1> product1List=null;
        String sql="select shp_id,shp_mch,flmch2,ppmch,chjshj,shp_msh,shp_jg,shp_ys,shp_kc,shp_zht\n" +
                "from product p,class_2 c,mark m where p.pp_id=m.pp_id and p.flmch2_id=c.flmch2_id and shp_mch=?";
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        product1List=qr.query(sql,new BeanListHandler<>(Product1.class),shp_mch);
        l=product1List.size();

        return l.intValue();

    }




}
