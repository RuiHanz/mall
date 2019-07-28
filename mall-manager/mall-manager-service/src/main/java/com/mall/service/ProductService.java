package com.mall.service;

import com.mall.service.product.Product;
import com.mall.service.product.Product1;
import com.mall.service.product.ProductImages;
import com.mall.service.utils.PageBean;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    //添加商品
    public boolean addProductService(String shp_id, String shp_mch, Integer flmch1_id, Integer flmch2_id, String pp_id, String chjshj, String shp_msh, float shp_jg, String shp_ys, Integer shp_kc, String shp_zht);
    //查询所有
    public List<Product> selectAllService();
    public List<Product1> selectAll1Service() throws SQLException;
    //查询，按名称
    public List<Product> selectByNameService(String shp_mch);
    public void selectByName1Service(PageBean<Product1> pageBean,String shp_mch) throws SQLException;

    //查询,按描述模糊查询
    public List<Product> selectByShp_mshService(String shp_msh);
    public void selectByShp_msh1Service(PageBean<Product1> pageBean,String shp_mch) throws SQLException;

    //查询，按id
    public List<Product> selectByShp_idService(String shp_id);
    public void selectByShp_id1Service(PageBean<Product1> pageBean,String shp_id) throws SQLException;

    public Product selectStaticByShp_idService(String shp_id) throws SQLException;

    //删除商品 按id
    public boolean deleteProductService(String shp_id);
    //修改商品 按id
    public void updateProductService(Product product,String id);
    public boolean updateProduct1Service(Product1 product1, String id) throws SQLException;

    //为商品增加图片 按shp_id
    public Integer addProductImageService(ProductImages productImages, String shp_id);
    //改变商品状态
    public void changeProductService(String shp_id);

    public void changeProduct1Service(String shp_id);

    /* 分页查询数据
     * */
    public  void  getAllService(PageBean<Product1> pageBean) throws SQLException;
}
