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
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/updateOrder.do")
public class UpdateOrderServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("utf-8");
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=UTF-8");
            String handle=req.getParameter("handle");
            switch (handle){
                case "delete":
                    try {
                        deleteOrder(req,resp);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "update":
                    updateOrder(req,resp);
                    break;

            }
        }

        private void updateOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String dd_id = req.getParameter("dd_id");
            String currentPage=req.getParameter("currentPage");
            List<String> list1=new ArrayList<String>();
            List<String> list=new ArrayList<String>();
            list.add(dd_id);
            IOrderService service = new OrderServiceImpl();
            List<Order> orderList = service.findOrderById(dd_id);
            req.setAttribute("orderList",orderList);
            req.setAttribute("id",list);
            list1.add(currentPage);
            req.setAttribute("currentPage",list1);
            req.getRequestDispatcher("订单修改页面.jsp").forward(req,resp);
        }

        private void deleteOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
            String dd_id = req.getParameter("dd_id");
            IOrderService service = new OrderServiceImpl();
            boolean isSuccess =service.removeOrderService(dd_id);
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
            }
            PrintWriter out = resp.getWriter();
            out.print("<script>alert('删除成功!');window.location.href='ordertables.jsp'</script>");
           /* //跳转
            req.getRequestDispatcher("/selectOrder.do").forward(req, resp);*/

        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doGet(req,resp);
        }
    }

