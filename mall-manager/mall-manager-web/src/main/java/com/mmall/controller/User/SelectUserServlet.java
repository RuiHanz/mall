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
import java.util.List;

@WebServlet("/selectUser.do")
public class SelectUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        Integer selecttype = Integer.parseInt(req.getParameter("selectType"));
        System.out.println(selecttype);

        switch (selecttype) {
            case 0:
                selectAllUser(req, resp);
                break;
            case 1:
                selectUserByName(req, resp);
                break;
            case 2:
                selectUserByPhone(req, resp);
                break;
        }
    }

    private void selectUserByPhone(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String yh_shjh=req.getParameter("searchName");
        List<User> userList=null;
        UserService userService=new UserServiceImpl();
        userList=userService.selectUserByPhoneService(yh_shjh);
        req.setAttribute("userList",userList);
        req.getRequestDispatcher("用户搜删改.jsp").forward(req,resp);
    }

    private void selectUserByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String yh_mch=req.getParameter("searchName");
        List<User> userList=null;
        UserService userService=new UserServiceImpl();
        userList=userService.selectUserByNameService(yh_mch);
        req.setAttribute("userList",userList);
        req.getRequestDispatcher("用户搜删改.jsp").forward(req,resp);
    }

    private void selectAllUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList=null;
        UserService userService=new UserServiceImpl();
        userList=userService.selectAllService();
        req.setAttribute("userList",userList);
        req.getRequestDispatcher("用户搜删改.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
