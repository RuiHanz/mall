package com.mmall.controller.User;

import com.mall.service.UserService;
import com.mall.service.impl.UserServiceImpl;
import com.mall.service.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/updateUser.do")
public class UpdateUserServlet extends HttpServlet {
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
            req.getRequestDispatcher("用户搜删改.jsp").forward(req,resp);
        }else {
            PrintWriter out = resp.getWriter();
            out.print("<script>alert('解封失败!');window.location.href='用户搜删改.jsp';</script>");
        }

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
            req.getRequestDispatcher("用户搜删改.jsp").forward(req,resp);
        }else {
            PrintWriter out = resp.getWriter();
            out.print("<script>alert('删除失败!');window.location.href='用户搜删改.jsp';</script>");
        }
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
            req.getRequestDispatcher("用户搜删改.jsp").forward(req,resp);
        }else {
            PrintWriter out = resp.getWriter();
            out.print("<script>alert('封禁失败!');window.location.href='用户搜删改.jsp';</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
