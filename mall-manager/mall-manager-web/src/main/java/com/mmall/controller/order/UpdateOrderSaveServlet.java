package com.mmall.controller.order;

import com.mall.service.ProductService;
import com.mall.service.impl.ProductServiceImpl;
import com.mall.service.impl.order.OrderServiceImpl;
import com.mall.service.order.IOrderService;
import com.mall.service.order.Order;
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

@WebServlet("/updateOrderSave.do")
public class UpdateOrderSaveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        Order order =new Order();
        String id = req.getParameter("id");
        System.out.println(id);
        String dd_id=req.getParameter("dd_id");
        order.setDd_id(dd_id);
        order.setShp_mch(req.getParameter("shp_mch"));
        order.setZje(Float.parseFloat(req.getParameter("zje")));
        order.setShhr(req.getParameter("shhr"));
        order.setDzh_mch(req.getParameter("dzh_mch"));
        Integer jdh1=null;
        String jdh=req.getParameter("jdh");
        if ("未支付".equals(jdh)){
            jdh1=0;
        }else if ("已支付".equals(jdh)){
            jdh1=1;
        }else if ("待评价".equals(jdh)){
            jdh1=2;
        }else {
            jdh1=2;
        }
        order.setJdh(Integer.valueOf(jdh1));
        order.setChjshj(req.getParameter("chjshj"));
        /*order.setYjsdshj(req.getParameter("yjsdshj"));*/
        IOrderService service = new OrderServiceImpl();
        try {
          service.modifyDdService(order,dd_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter out = resp.getWriter();
        out.print("<script>alert('修改成功!');window.location.href='ordertables.jsp'</script>");
        try {
            //获取“当前页”参数(第一次访问时当前页为null)
            String currPage = req.getParameter("currentPage");

            //判断   第一次是设置默认值
            if(currPage == null || "".equals(currPage)){
                currPage = "1";
            }

            //转换   从jsp获取的都是字符串型的    需转换为整形才能保存到javaBean中
            int currentPage = Integer.parseInt(currPage);

            PageBean<Order> pb = new PageBean<Order>();
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
        req.getRequestDispatcher("ordertables.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
