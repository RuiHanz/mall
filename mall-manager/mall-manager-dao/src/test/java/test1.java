import com.mall.service.impl.markAndclass.dao.impl.MarkDaoImpl;
import com.mall.service.impl.product.ProductDaoImpl;
import com.mall.service.impl.user.UserDaoImpl;
import com.mall.service.markAndclass.Mark;
import com.mall.service.markAndclass.MarkDao;
import com.mall.service.product.Product;
import com.mall.service.product.ProductDao;
import com.mall.service.product.ProductImages;
import com.mall.service.user.IUserDao;
import com.mall.service.user.User;
import com.mall.service.utils.UUIDUtils;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

public class test1 {
    @Test
    public void testDmo1(){
        ProductDaoImpl dao=new ProductDaoImpl();
        List<Product> productList=dao.selectAll();
        for(Product product:productList) {
            System.out.println(product);
        }
    }
    @Test
    public void testDemo2(){
        ProductDao dao=new ProductDaoImpl();
        List<Product> productList=dao.selectByName("外星人");
        for(Product product:productList) {
            System.out.println(product);
        }
    }
    @Test
    public void testDemo3(){
        ProductDao dao=new ProductDaoImpl();
        List<Product> productList=dao.selectByShp_msh("i7");
        for(Product product:productList) {
            System.out.println(product);
        }
    }
    @Test
    public void testDemo4(){
        ProductDao dao=new ProductDaoImpl();
        List<Product> productList=dao.selectByShp_id("2");
        for(Product product:productList) {
            System.out.println(product);
        }
    }
    @Test
    public void testDemo5(){
        ProductDao dao=new ProductDaoImpl();
        Product product=new Product();
        product.setShp_id("8");
        product.setShp_mch("8");
        product.setFlmch1_id(0);
        product.setFlmch2_id(0);
        product.setPp_id("2");
        product.setShp_ys("8");
        product.setShp_kc(8);
        product.setShp_jg((float)8.0);
        product.setShp_msh("8");
        product.setChjshj("8");
        dao.updateProduct(product,"4");
    }
    @Test
    public void testDemo6(){
        IUserDao dao=new UserDaoImpl();
        List<User> userList= null;
        try {
            userList = dao.login("18303412059","abcd986532");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(User user:userList) {
            System.out.println(user);
        }
    }
    @Test
    public void testDemo7(){
        ProductDao dao = new ProductDaoImpl();
        UUIDUtils uuidUtils=new UUIDUtils();
        ProductImages productImages=new ProductImages();
        productImages.setTu_Id(uuidUtils.getId());
        productImages.setTu_mch("实验1");
        productImages.setZy("实验");
        productImages.setShp_id(uuidUtils.getId());
        productImages.setUrl("adc");
        dao.addProductImage(productImages,productImages.getShp_id());
    }
    @Test
    public void testDemo8(){
        MarkDao dao=new MarkDaoImpl();
        try {
            dao.deleteMarkById("8");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testDemo9() throws SQLException {
        MarkDao dao=new MarkDaoImpl();
        Mark mark=new Mark();
        mark.setPp_id("8");
        mark.setPpmch("8");
        mark.setFlmch1_id(0);
        mark.setUrl("8");
        dao.updateMarkById(mark,"7");
    }
    @Test
    public void testDemo10(){
        IUserDao dao= new UserDaoImpl();
        dao.closeUser("1");
    }
    @Test
    public void testDemo11(){
        IUserDao dao= new UserDaoImpl();
        dao.openUser("1");
    }
    @Test
    public void testDemo12(){
        IUserDao dao= new UserDaoImpl();
        dao.deleteUser("1");
    }

}
