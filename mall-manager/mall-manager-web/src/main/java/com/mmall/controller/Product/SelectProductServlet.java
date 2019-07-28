package com.mmall.controller.Product;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mall.service.MarkService;
import com.mall.service.ProductService;
import com.mall.service.impl.MarkServiceImpl;
import com.mall.service.impl.ProductServiceImpl;
import com.mall.service.impl.markAndclass.dao.impl.Class2DaoImpl;
import com.mall.service.markAndclass.Class2;
import com.mall.service.markAndclass.IClass2Dao;
import com.mall.service.markAndclass.Mark;
import com.mall.service.product.Product;
import com.mall.service.product.Product1;
import com.mall.service.utils.JSONUtils;
import com.mall.service.utils.JdbcUtils;
import com.mall.service.utils.PageBean;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/select.do")
public class SelectProductServlet extends HttpServlet {
    private ProductService service = new ProductServiceImpl();
    private String uri;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");


        Integer selecttype = Integer.parseInt(req.getParameter("selectType"));
        System.out.println(selecttype);

        switch (selecttype){
            case 0 :
                try {
                    selectAll(req,resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 1 :
                try {
                    selectByName(req,resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 2 :
                try {
                    selectById(req,resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 3 :
                try {
                    selectByShp_msh(req,resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
//id查询
    private void selectById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String shp_id=req.getParameter("searchName");
        try {
            //获取“当前页”参数(第一次访问时当前页为null)
            String currPage = req.getParameter("currentPage");

            //判断   第一次是设置默认值
            if(currPage == null || "".equals(currPage)){
                currPage = "1";
            }

            //转换   从jsp获取的都是字符串型的    需转换为整形才能保存到javaBean中
            int currentPage = Integer.parseInt(currPage);

            PageBean<Product1> pb = new PageBean<Product1>();
            pb.setCurrentPage(currentPage);

            //调用service层
            service.selectByShp_id1Service(pb,shp_id);

            //保存域对象
            req.setAttribute("pageBean", pb);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        //跳转
        req.getRequestDispatcher("tables.jsp").forward(req, resp);
    }

    //关键词模糊查询
    private void selectByShp_msh(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String shp_msh=req.getParameter("searchName");
        try {
            //获取“当前页”参数(第一次访问时当前页为null)
            String currPage = req.getParameter("currentPage");

            //判断   第一次是设置默认值
            if(currPage == null || "".equals(currPage)){
                currPage = "1";
            }

            //转换   从jsp获取的都是字符串型的    需转换为整形才能保存到javaBean中
            int currentPage = Integer.parseInt(currPage);

            PageBean<Product1> pb = new PageBean<Product1>();
            pb.setCurrentPage(currentPage);

            //调用service层
            service.selectByShp_msh1Service(pb,shp_msh);

            //保存域对象
            req.setAttribute("pageBean", pb);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        //跳转
        req.getRequestDispatcher("tables.jsp").forward(req, resp);

    }
//商品名称查询
    private void selectByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String shp_mch=req.getParameter("searchName");
//        List<Product1> product1List=null;
        try {
            //获取“当前页”参数(第一次访问时当前页为null)
            String currPage = req.getParameter("currentPage");

            //判断   第一次是设置默认值
            if(currPage == null || "".equals(currPage)){
                currPage = "1";
            }

            //转换   从jsp获取的都是字符串型的    需转换为整形才能保存到javaBean中
            int currentPage = Integer.parseInt(currPage);

            PageBean<Product1> pb = new PageBean<Product1>();
            pb.setCurrentPage(currentPage);

            //调用service层
            service.selectByName1Service(pb,shp_mch);

            //保存域对象
            req.setAttribute("pageBean", pb);


        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        //跳转
        req.getRequestDispatcher("tables.jsp").forward(req, resp);

//        JSONObject jsonObject=new JSONObject();
//        jsonObject.put("productList",product1List);
//        JSONUtils.returnJSON(req,resp,jsonObject);

//        req.setAttribute("productList",product1List);
//        req.getRequestDispatcher("tables.jsp").forward(req,resp);
    }

    private void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
            try {
            //获取“当前页”参数(第一次访问时当前页为null)
            String currPage = req.getParameter("currentPage");

            //判断   第一次是设置默认值
            if(currPage == null || "".equals(currPage)){
                currPage = "1";
            }

            //转换   从jsp获取的都是字符串型的    需转换为整形才能保存到javaBean中
            int currentPage = Integer.parseInt(currPage);

            PageBean<Product1> pb = new PageBean<Product1>();
            pb.setCurrentPage(currentPage);

            //调用service层
            service.getAllService(pb);

            //保存域对象
            req.setAttribute("pageBean", pb);


            } catch (NumberFormatException e) {
                 e.printStackTrace();
            }

            //跳转
            req.getRequestDispatcher("tables.jsp").forward(req, resp);

//            List<Product1> product1List=null;
//            ProductService productService=new ProductServiceImpl();
//            product1List=productService.selectAll1Service();
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(product1List));
//        JSONObject jsonObject= new JSONObject();
//        jsonObject.put("productList",jsonArray);
//        JSONUtils.returnJSON(req,resp,jsonObject);


//        req.setAttribute("productList",product1List);


//        req.getRequestDispatcher("tables.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //获取json数据
//        JSONObject jsonObject=JSONUtils.getJSON(req,resp);
//        MarkService markService=new MarkServiceImpl();
//        IClass2Dao dao=new Class2DaoImpl();
//        Product1 product1=new Product1();
//        product1.setShp_id(jsonObject.getString("shp_id"));
//        product1.setShp_mch(jsonObject.getString("shp_mch"));
//        product1.setPpmch(jsonObject.getString("ppmch"));
//        product1.setFlmch2(jsonObject.getString("flmch2"));
//        product1.setShp_jg(jsonObject.getFloat("shp_jg"));
//        product1.setShp_kc(jsonObject.getInteger("shp_kc"));
//        product1.setShp_msh(jsonObject.getString("shp_msh"));
//        product1.setShp_ys(jsonObject.getString("shp_ys"));
//        product1.setShp_zht(jsonObject.getString("shp_zht"));
//        product1.setChjshj(jsonObject.getString("chjshj"));
//
//        String pp_id=null;
//        try {
//            pp_id=markService.selectMarkIdByNameService(product1.getPpmch()).getPp_id();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        Integer flmch2_id=null;
//        try {
//            flmch2_id=dao.selectIdByName(product1.getFlmch2()).getFlmch2_id();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        ProductService productService=new ProductServiceImpl();
//        boolean isSuccess=productService.addProductService(product1.getShp_id(),product1.getShp_mch(),0,flmch2_id,pp_id,product1.getChjshj(),product1.getShp_msh(),product1.getShp_jg(),product1.getShp_ys(),product1.getShp_kc(),product1.getShp_zht());
//
//        //返回json数据
//        JSONObject jsonObject1=new JSONObject();
//        jsonObject1.put("isSucess",isSuccess);
//        JSONUtils.returnJSON(req,resp,jsonObject1);
        doGet(req,resp);
    }
}
