package com.mmall.controller.Product;

import com.mall.service.ProductService;
import com.mall.service.impl.ProductServiceImpl;
import com.mall.service.product.Product;
import com.mall.service.product.ProductImages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/update.do")
public class UpdateProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        String handle=req.getParameter("handle");
        switch (handle){
            case "update":
                updateProduct(req,resp);
                break;
            case "delete":
                deleteProduct(req,resp);
                break;
            case "addPicture":
                addPicture(req,resp);

        }

    }

    private void addPicture(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String shp_id = req.getParameter("shp_id");
        List<String> list=new ArrayList<String>();
        list.add(shp_id);
        req.setAttribute("shp_id",list);
        req.getRequestDispatcher("商品添加图片.jsp").forward(req,resp);
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String shp_id = req.getParameter("shp_id");
        ProductService productService=new ProductServiceImpl();
        productService.deleteProductService(shp_id);
        PrintWriter out = resp.getWriter();
        out.print("<script>alert('删除成功!');window.location.href='tables.jsp';</script>");
        List<Product> productList=null;
        productList=productService.selectAllService();
        req.setAttribute("productList",productList);
        req.getRequestDispatcher("tables.jsp").forward(req,resp);
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String shp_id = req.getParameter("shp_id");
        List<String> list=new ArrayList<String>();
        list.add(shp_id);

        ProductService productService=new ProductServiceImpl();
        List<Product> productList=productService.selectByShp_idService(shp_id);
        req.setAttribute("productList",productList);
        req.setAttribute("id",list);
        req.getRequestDispatcher("商品修改页面2.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
