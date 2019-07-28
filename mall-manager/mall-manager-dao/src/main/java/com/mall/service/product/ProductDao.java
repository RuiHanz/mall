package com.mall.service.product;

import com.mall.service.utils.PageBean;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    //添加商品
    public void addProduct(String shp_id,String shp_mch,Integer flmch1_id,Integer flmch2_id,String pp_id,String chjshj,String shp_msh,float shp_jg,String shp_ys,Integer shp_kc,String shp_zht );

    //查询全部
    public List<Product> selectAll();
    public List<Product1> selectAll1() throws SQLException;
    //查询，按名称
    public List<Product> selectByName(String shp_mch);
    public void selectByName1(PageBean<Product1> pageBean,String shp_mch) throws SQLException;
    //查询,按描述模糊查询
    public List<Product> selectByShp_msh(String shp_msh);
    public void selectByShp_msh1(PageBean<Product1> pageBean,String shp_mch) throws SQLException;
    //查询，按id
    public List<Product> selectByShp_id(String shp_id);
    public void selectByShp_id1(PageBean<Product1> pageBean,String shp_id) throws SQLException;

    //查询商品状态
    public Product selectStaticByShp_id(String shp_id) throws SQLException;

    //删除商品 按id
    public void deleteProduct(String shp_id);

    //修改商品 按id
    public void updateProduct(Product product,String id);
    public void updateProduct1(Product1 product1,String id) throws SQLException;
    //下架
    public void changeProduct(String shp_id);

    //上架
    public void changeProduct1(String shp_id);

    //为商品增加图片 按shp_id
    public Integer addProductImage(ProductImages productImages, String shp_id);
}
