package com.mmall.controller;

import com.mall.service.ProductService;
import com.mall.service.impl.ProductServiceImpl;
import com.mall.service.product.Product1;
import com.mall.service.product.ProductImages;
import com.mall.service.utils.PageBean;
import com.mall.service.utils.UUIDUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/addProductImage.do")
public class AddProductImageServlet extends HttpServlet {
    private ProductService service = new ProductServiceImpl();

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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //跳转
        req.getRequestDispatcher("tables.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
