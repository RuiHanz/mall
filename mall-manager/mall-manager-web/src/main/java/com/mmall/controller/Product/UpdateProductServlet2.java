package com.mmall.controller.Product;

import com.mall.service.ProductService;
import com.mall.service.impl.ProductServiceImpl;
import com.mall.service.markAndclass.Mark;
import com.mall.service.product.Product;
import com.mall.service.product.Product1;
import com.mall.service.utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/updateProduct2.do")
public class UpdateProductServlet2 extends HttpServlet {
    private ProductService service = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        Product1 product=new Product1();
        String id=req.getParameter("id");
        System.out.println(id);
        String shp_id=req.getParameter("shp_id");
        product.setShp_id(shp_id);
        product.setShp_mch(req.getParameter("shp_mch"));
        product.setFlmch2(req.getParameter("flmch2"));
        product.setPpmch(req.getParameter("ppmch"));
        product.setShp_kc(Integer.parseInt(req.getParameter("shp_kc")));
        product.setShp_jg(Float.parseFloat(req.getParameter("shp_jg")));
        product.setChjshj(req.getParameter("chjshj"));
        ProductService productService=new ProductServiceImpl();
        try {
            productService.updateProduct1Service(product,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter out = resp.getWriter();
        out.print("<script>alert('修改成功!');window.location.href='tables.jsp'</script>");
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
