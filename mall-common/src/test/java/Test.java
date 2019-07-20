import com.mall.service.utils.JdbcUtils;

public class Test {
    @org.junit.Test
    public void test1(){
        JdbcUtils jdbcUtils=new JdbcUtils();
        System.out.println( jdbcUtils.getDs());
    }

}
