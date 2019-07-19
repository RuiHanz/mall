package com.mmall.controller;

import com.mall.service.ProductService;
import com.mall.service.impl.ProductServiceImpl;
import com.mall.service.product.ProductImages;
import com.mall.service.utils.UUIDUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addProductImage.do")
public class AddProductImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUIDUtils uuidUtils=new UUIDUtils();
        ProductImages productImages=new ProductImages();

        productImages.setTu_Id(uuidUtils.getId());
        productImages.setTu_mch(req.getParameter("tu_mch"));
        productImages.setZy(req.getParameter("zy"));
        productImages.setShp_id(req.getParameter("shp_id"));
        productImages.setUrl(req.getParameter("url"));

        ProductService productService=new ProductServiceImpl();
        Integer i=productService.addProductImageService(productImages,productImages.getShp_id());
        System.out.println(i);
        if(i==1){
            PrintWriter out = resp.getWriter();
            out.print("<script>alert('添加图片成功!');window.location.href='tables.jsp';</script>");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
