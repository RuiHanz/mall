import com.mall.service.MarkService;
import com.mall.service.ProductService;
import com.mall.service.impl.MarkServiceImpl;
import com.mall.service.impl.ProductServiceImpl;
import com.mall.service.markAndclass.Mark;
import com.mall.service.product.Product;
import com.mall.service.utils.JdbcUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Test1 {
    @Test
    public void test2() throws SQLException {
        List<Product> productList=null;
        ProductService productService=new ProductServiceImpl();
        productList=productService.selectAllService();
        List<String> list1=new ArrayList<String>();

        String sql1 = "select * from product";
        List<Mark> list=new ArrayList<Mark>();

        ResultSet rs=null;
        Connection connection=null;
        Statement stmt=null;
        connection= JdbcUtils.getConnection();
        stmt=connection.createStatement();
        MarkService markService=new MarkServiceImpl();
        try{
            rs=stmt.executeQuery(sql1) ;
//            System.out.println(rs);
            while(rs.next()){
                list1.add(rs.getString("pp_id"));
//                System.out.println(list1);
            }
//            System.out.println(list1);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
//        System.out.println(list1);

        for (String pp_id:list1){
            list.add(markService.selectMarkNameByIdService(pp_id));
//            System.out.println(list);
        }
        System.out.println(list);
    }
}
