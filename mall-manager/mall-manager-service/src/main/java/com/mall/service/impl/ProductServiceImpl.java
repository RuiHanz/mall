package com.mall.service.impl;

import com.mall.service.ProductService;
import com.mall.service.impl.product.Product1DaoImpl;
import com.mall.service.impl.product.ProductDaoImpl;
import com.mall.service.product.*;
import com.mall.service.utils.PageBean;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public boolean addProductService(String shp_id, String shp_mch, Integer flmch1_id, Integer flmch2_id, String pp_id, String chjshj, String shp_msh, float shp_jg, String shp_ys, Integer shp_kc, String shp_zht) {

        ProductDao dao = new ProductDaoImpl();
        dao.addProduct(shp_id,shp_mch,flmch1_id,flmch2_id,pp_id,chjshj,shp_msh,shp_jg,shp_ys,shp_kc,shp_zht);
        return false;
    }

    @Override
    public List<Product> selectAllService() {
        ProductDao dao = new ProductDaoImpl();
        List<Product> productList=null;
        productList=dao.selectAll();
        return productList;
    }

    @Override
    public List<Product1> selectAll1Service() throws SQLException {
        ProductDao dao = new ProductDaoImpl();
        List<Product1> product1List=null;
        product1List=dao.selectAll1();
        return product1List;
    }

    @Override
    public List<Product> selectByNameService(String shp_mch) {
        ProductDao dao = new ProductDaoImpl();
        List<Product> productList=null;
        productList=dao.selectByName(shp_mch);
        return productList;


    }

    @Override
    public void selectByName1Service(PageBean<Product1> pageBean, String shp_mch) throws SQLException {
        ProductDao dao=new ProductDaoImpl();
        dao.selectByName1(pageBean, shp_mch);
    }



    @Override
    public List<Product> selectByShp_mshService(String shp_msh) {
        ProductDao dao = new ProductDaoImpl();
        List<Product> productList=null;
        productList=dao.selectByShp_msh(shp_msh);
        return productList;
    }

    @Override
    public void selectByShp_msh1Service(PageBean<Product1> pageBean, String shp_mch) throws SQLException {
        ProductDao dao=new ProductDaoImpl();
        dao.selectByShp_msh1(pageBean,shp_mch);
    }



    @Override
    public List<Product> selectByShp_idService(String shp_id) {
        ProductDao dao = new ProductDaoImpl();
        List<Product> productList=null;
        productList=dao.selectByShp_id(shp_id);
        return productList;
    }

    @Override
    public void selectByShp_id1Service(PageBean<Product1> pageBean, String shp_id) throws SQLException {
        ProductDao dao=new ProductDaoImpl();
        dao.selectByShp_id1(pageBean, shp_id);
    }


    @Override
    public Product selectStaticByShp_idService(String shp_id) throws SQLException {
        ProductDao dao = new ProductDaoImpl();
        Product product=new Product();
        product=dao.selectStaticByShp_id(shp_id);
        return product;
    }

    @Override
    public boolean deleteProductService(String shp_id) {
        ProductDao dao = new ProductDaoImpl();
        dao.deleteProduct(shp_id);
        return false;

    }

    @Override
    public void updateProductService(Product product, String id) {
        ProductDao dao = new ProductDaoImpl();
        dao.updateProduct(product,id);
    }

    @Override
    public boolean updateProduct1Service(Product1 product1, String id) throws SQLException {
        ProductDao dao = new ProductDaoImpl();
        dao.updateProduct1(product1,id);
        return false;
    }

    @Override
    public Integer addProductImageService(ProductImages productImages, String shp_id) {
        ProductDao dao = new ProductDaoImpl();
        dao.addProductImage(productImages,shp_id);
        return 1;
    }

    @Override
    public void changeProductService(String shp_id) {
        ProductDao dao = new ProductDaoImpl();
        dao.changeProduct(shp_id);
    }

    @Override
    public void changeProduct1Service(String shp_id) {
        ProductDao dao = new ProductDaoImpl();
        dao.changeProduct1(shp_id);
    }

    @Override
    public void getAllService(PageBean<Product1> pageBean) throws SQLException {
        IProductDao dao=new Product1DaoImpl();
        dao.getAll(pageBean);
    }
}
