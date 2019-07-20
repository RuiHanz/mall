package com.mall.service.impl;

import com.mall.service.*;
import com.mall.service.utils.JdbcUtils;
import com.mall.service.utils.UUIDUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public Integer addOrder(String gwc_id,String yjsdshj,Integer jdh) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "insert into secondprogram1.order(dd_id,yh_id,chjshj,zje,shhr,jdh,yjsdshj,dzh_mch)" +
                "                value(?,?,date_format(CURRENT_TIMESTAMP,'%Y-%c-%d'),?,?,?,?,?);";
        AddressDao addressDao=new AddressDaoImpl();
        List<address> addressList=null;
        ShoppingCarDao shoppingCarDao=new ShoppingCarDaoImpl();
        UUIDUtils uuidUtils=new UUIDUtils();
        String dd_id=uuidUtils.getId();                       //订单id
        java.sql.Date date=java.sql.Date.valueOf(yjsdshj);    //预计送达时间


        List<ShoppingCar> shoppingCarList=null;
        shoppingCarList=shoppingCarDao.selectById(gwc_id);    //查询购物车信息通过id，返回一个list
        for (ShoppingCar shoppingCar:shoppingCarList){
            addressList=addressDao.selectAddressByYh_id(shoppingCar.getYh_id());  //通过查询的购物车信息查询用户地址信息
            for (address address:addressList){
                Float zje=shoppingCar.getShp_shl()*shoppingCar.getShp_jg();
                qr.update(sql,dd_id,shoppingCar.getYh_id(),zje,address.getShjr(),jdh,date,address.getDz_mch());
            }
        }

        return 1;





    }
}
