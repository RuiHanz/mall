package com.mmall.controller.order;

import com.mall.service.impl.order.OrderServiceImpl;
import com.mall.service.order.IOrderService;
import com.mall.service.order.Order;
import com.mall.service.utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/selectOrder.do")
public class SelectOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        Integer selecttype = Integer.parseInt(req.getParameter("selectType"));
        System.out.println(selecttype);
        switch (selecttype){
            case 0 :
                selectOrderAll(req,resp);
                break;
            case 1 :
                selectOrderById(req,resp);
                break;
            case 2 :
                selectOrderByShhr(req,resp);
                break;
            case 3 :
                selectOrderByShp_mch(req,resp);
                break;
        }

    }
//按商品名称查询
    private void selectOrderByShp_mch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String shp_mch=req.getParameter("searchName");
        IOrderService service = new OrderServiceImpl();
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
            try {
                service.findDdByShp_mch1Service(pb,shp_mch);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //保存域对象
            req.setAttribute("pageBean", pb);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        //跳转
        req.getRequestDispatcher("ordertables.jsp").forward(req, resp);

    }
//按收货人查询
    private void selectOrderByShhr(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String shhr=req.getParameter("searchName");
        IOrderService service = new OrderServiceImpl();
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
            try {
                service.findDdByShhr1Service(pb,shhr);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //保存域对象
            req.setAttribute("pageBean", pb);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        //跳转
        req.getRequestDispatcher("ordertables.jsp").forward(req, resp);
    }
    //按订单id查询
    private void selectOrderById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dd_id=req.getParameter("searchName");
        IOrderService service = new OrderServiceImpl();
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
            try {
                service.findDdById1Service(pb,dd_id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //保存域对象
            req.setAttribute("pageBean", pb);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        //跳转
        req.getRequestDispatcher("ordertables.jsp").forward(req, resp);
    }

    private void selectOrderAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      IOrderService service =new OrderServiceImpl();
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
            try {
                service.getAllService(pb);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //保存域对象
            req.setAttribute("pageBean", pb);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        //跳转
        req.getRequestDispatcher("ordertables.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
