package com.mmall.controller.Product;

import com.alibaba.fastjson.JSONObject;
import com.mall.service.ProductService;
import com.mall.service.impl.ProductServiceImpl;
import com.mall.service.impl.product.ProductDaoImpl;
import com.mall.service.product.Product;
import com.mall.service.product.Product1;
import com.mall.service.product.ProductImages;
import com.mall.service.utils.JSONUtils;
import com.mall.service.utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/update.do")
public class UpdateProductServlet extends HttpServlet {
    private ProductService service = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        String handle=req.getParameter("handle");
        switch (handle){
            case "update":
                try {
                    updateProduct(req,resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteProduct(req,resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "addPicture":
                addPicture(req,resp);
                break;
            case "change":
                try {
                    change(req,resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }

    }

    private void change(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String shp_id = req.getParameter("shp_id");

        Product product = new Product();

        ProductService productService=new ProductServiceImpl();
        product=productService.selectStaticByShp_idService(shp_id);
        if ("上架".equals(product.getShp_zht())){
            productService.changeProductService(shp_id);
        }else if ("下架".equals(product.getShp_zht())){
            productService.changeProduct1Service(shp_id);
        }


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
    }

    private void addPicture(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String shp_id = req.getParameter("shp_id");
        String currentPage=req.getParameter("currentPage");
        List<String> list1=new ArrayList<String>();

        List<String> list=new ArrayList<String>();
        list.add(shp_id);
        req.setAttribute("shp_id",list);
        list1.add(currentPage);
        req.setAttribute("currentPage",list1);
        req.getRequestDispatcher("商品添加图片.jsp").forward(req,resp);
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, SQLException {


        String shp_id = req.getParameter("shp_id");

//        JSONObject jsonObject= JSONUtils.getJSON(req,resp);
//        String shp_id1=jsonObject.getString("shp_id");
        ProductService productService=new ProductServiceImpl();
        boolean isSuccess =productService.deleteProductService(shp_id);

//        JSONObject jsonObjOut = new JSONObject();
//        jsonObjOut.put("isSuccess", isSuccess);
//        JSONUtils.returnJSON(req, resp, jsonObjOut);
//        PrintWriter out =  resp.getWriter();
//        resp.setContentType("text/html");
//        resp.setCharacterEncoding("UTF-8");
//        out.print(1);

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
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String shp_id = req.getParameter("shp_id");
        String currentPage=req.getParameter("currentPage");
        List<String> list=new ArrayList<String>();
        list.add(shp_id);
        ProductDaoImpl dao=new ProductDaoImpl();
        List<String> list1=new ArrayList<String>();
        List<Product1> product1List=dao.selectByShp_id2(shp_id);
        req.setAttribute("productList",product1List);
        req.setAttribute("id",list);

        list1.add(currentPage);
        req.setAttribute("currentPage",list1);
        req.getRequestDispatcher("商品修改页面2.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
