package com.mmall.controller.User;

import com.mall.service.UserService;
import com.mall.service.impl.UserServiceImpl;
import com.mall.service.user.User;
import com.mall.service.utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/updateUser.do")
public class UpdateUserServlet extends HttpServlet {
    private UserService service = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        String handle=req.getParameter("handle");
        switch (handle){
            case "close":
                closeUser(req,resp);
                break;
            case "delete":
                deleteUser(req,resp);
                break;
            case "open":
                openUser(req,resp);
                break;

        }
    }

    private void openUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String yh_id = req.getParameter("yh_id");
        System.out.println(yh_id);
        UserService userService=new UserServiceImpl();
        Integer i = userService.openUserService(yh_id);
        if (i==1) {
            PrintWriter out = resp.getWriter();
            out.print("<script>alert('解封成功!');window.location.href='用户搜删改.jsp';</script>");
            List<User> userList=null;
            userList=userService.selectAllService();
            req.setAttribute("userList",userList);
            //req.getRequestDispatcher("用户搜删改.jsp").forward(req,resp);
        }else {
            PrintWriter out = resp.getWriter();
            out.print("<script>alert('解封失败!');window.location.href='用户搜删改.jsp';</script>");
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

            PageBean<User> pb = new PageBean<User>();
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
        req.getRequestDispatcher("用户搜删改.jsp").forward(req, resp);

    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String yh_id = req.getParameter("yh_id");
        UserService userService=new UserServiceImpl();
        Integer i = userService.deleteUserService(yh_id);
        if (i==1) {
            PrintWriter out = resp.getWriter();
            out.print("<script>alert('删除成功!');window.location.href='用户搜删改.jsp';</script>");
            List<User> userList=null;
            userList=userService.selectAllService();
            req.setAttribute("userList",userList);
            //req.getRequestDispatcher("用户搜删改.jsp").forward(req,resp);
        }else {
            PrintWriter out = resp.getWriter();
            out.print("<script>alert('删除失败!');window.location.href='用户搜删改.jsp';</script>");
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

            PageBean<User> pb = new PageBean<User>();
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
        req.getRequestDispatcher("用户搜删改.jsp").forward(req, resp);
    }

    private void closeUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String yh_id = req.getParameter("yh_id");
        System.out.println(yh_id);
        UserService userService=new UserServiceImpl();
        Integer i = userService.closeUserService(yh_id);


        if (i==1) {
            PrintWriter out = resp.getWriter();
            out.print("<script>alert('封禁成功!');</script>");
            List<User> userList=null;
            userList=userService.selectAllService();
            req.setAttribute("userList",userList);
            //req.getRequestDispatcher("用户搜删改.jsp").forward(req,resp);
        }else {
            PrintWriter out = resp.getWriter();
            out.print("<script>alert('封禁失败!');window.location.href='用户搜删改.jsp';</script>");
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

            PageBean<User> pb = new PageBean<User>();
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
        req.getRequestDispatcher("用户搜删改.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
