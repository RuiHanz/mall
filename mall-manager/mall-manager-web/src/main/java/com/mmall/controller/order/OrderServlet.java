package com.mmall.controller.order;



import com.mall.service.impl.order.OrderServiceImpl;
import com.mall.service.order.IOrderService;
import com.mall.service.order.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/order.do")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String fun = request.getParameter("_method");
      switch (fun){
          case  "insert":
              selectAll(request,response);
              break;
          case "add":
              add(request,response);
              break;
          case "update":
              update(request,response);
              break;
          case "delete":
              delete(request,response);
              break;
          case "save":
              save(request,response);
              break;
          case "modifySave":
              modifySave(request,response);
              break;
      }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request,response);
    }
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IOrderService service = new OrderServiceImpl();
        List<Order> orderList = service.findAll();
        request.setAttribute("orderList",orderList);
        request.getRequestDispatcher("/ordertables.jsp").forward(request,response);
    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*request.getRequestDispatcher("/addorder.jsp").forward(request,response);*/
    }
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String  dd_id = request.getParameter("dd_id");
        IOrderService service = new OrderServiceImpl();
        Order order = service.findOrderById(dd_id);
        request.setAttribute("order",order);
        request.getRequestDispatcher("/addorder.jsp").forward(request,response);
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String dd_id =request.getParameter("dd_id");
        IOrderService service = new OrderServiceImpl();
        service.removeOrder(dd_id);
        response.sendRedirect("/order.do?_method=insert");
    }
    public void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        String  dd_id = request.getParameter("dd_id");
        String yh_id =request.getParameter("yh_id");
       /* String mai_id = request.getParameter("mai_id");*/
        String shp_mch = request.getParameter("shp_mch");
        float zje = Float.parseFloat(request.getParameter("zje"));
        String shhr=request.getParameter("shhr");
        String dzh_mch = request.getParameter("dzh_mch");
        System.out.println(dzh_mch);
        int jdh =Integer.valueOf(request.getParameter("jdh"));
        String chjshj = request.getParameter("chjshj");
        String yjsdshj = request.getParameter("yjsdshj");
        Order order = new Order();
        order.setDd_id(dd_id);
        order.setYh_id(yh_id);
   /*     order.setMai_id(mai_id);*/
        order.setShp_mch(shp_mch);
        order.setZje(zje);
        order.setShhr(shhr);
        order.setDzh_mch(dzh_mch);
        order.setJdh(jdh);
        order.setChjshj(chjshj);
        order.setYjsdshj(yjsdshj);
        System.out.println(order);
        IOrderService service = new OrderServiceImpl();
        service.addOrder(order);
        //重定向到主页面
        response.sendRedirect("/");
    }

    public void modifySave(HttpServletRequest request, HttpServletResponse response) throws IOException {
       // request.setCharacterEncoding("utf-8");
        String  dd_id = request.getParameter("dd_id");
        String yh_id =request.getParameter("yh_id");
        String mai_id = request.getParameter("mai_id");
        String shp_mch = request.getParameter("shp_mch");
        float zje = Float.parseFloat(request.getParameter("zje"));
        String shhr=request.getParameter("shhr");
        String dzh_mch = request.getParameter("dzh_mch");
        int jdh =Integer.valueOf(request.getParameter("jdh"));
        String chjshj = request.getParameter("chjshj");
        String yjsdshj = request.getParameter("yjsdshj");
        Order order = new Order();
        order.setDd_id(dd_id);
        order.setYh_id(yh_id);
        order.setMai_id(mai_id);
        order.setShp_mch(shp_mch);
        order.setZje(zje);
        order.setShhr(shhr);
        order.setDzh_mch(dzh_mch);
        order.setJdh(jdh);
        order.setChjshj(chjshj);
        order.setYjsdshj(yjsdshj);
        System.out.println(order);
        IOrderService service = new OrderServiceImpl();
        service.modifyOrder(order);
        //重定向到订单管理页面
        response.sendRedirect("/ordertables.jsp");
    }
}
