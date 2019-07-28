package com.mall.service.impl.product;

import com.mall.service.product.IProductDao;
import com.mall.service.product.Product1;
import com.mall.service.utils.JdbcUtils;
import com.mall.service.utils.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class Product1DaoImpl implements IProductDao {
    @Override
        public void getAll(PageBean<Product1> pageBean) throws SQLException {

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
        String sql = "select shp_id,shp_mch,flmch2,ppmch,chjshj,shp_msh,shp_jg,shp_ys,shp_kc,shp_zht\n" +
                "from product p,class_2 c,mark m where p.pp_id=m.pp_id and p.flmch2_id=c.flmch2_id limit ?,?";

        List<Product1> product1List = qr.query(sql, new BeanListHandler<>(Product1.class), index, count);
        pageBean.setList(product1List);

    }



        public int getTotalCount() throws SQLException {
            Integer l=null;
            List<Product1> product1List=null;
            String sql = "select shp_id,shp_mch,flmch2,ppmch,chjshj,shp_msh,shp_jg,shp_ys,shp_kc,shp_zht\n" +
                    "from product p,class_2 c,mark m where p.pp_id=m.pp_id and p.flmch2_id=c.flmch2_id";
            QueryRunner qr = new QueryRunner(JdbcUtils.getDs());

            product1List=qr.query(sql,new BeanListHandler<>(Product1.class));
            l=product1List.size();

            return l.intValue();

        }


}
