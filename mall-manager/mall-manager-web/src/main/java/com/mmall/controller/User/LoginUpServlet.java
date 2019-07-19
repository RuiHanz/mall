package com.mmall.controller.User;

import com.mall.service.UserService;
import com.mall.service.impl.UserServiceImpl;
import com.mall.service.impl.user.UserDaoImpl;
import com.mall.service.product.Product;
import com.mall.service.user.IUserDao;
import com.mall.service.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/login.do")
public class LoginUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String yh_shjh=req.getParameter("phoneNumber");
        String yh_mm=req.getParameter("password");

//        List<User> userList=null;
//        UserService userService=new UserServiceImpl();
//        try {
//            userList= userService.login(yh_shjh,yh_mm);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        if ("18303412059".equals(yh_shjh)&&"abcd986532".equals(yh_mm)){
            PrintWriter out = resp.getWriter();
            out.print("<script>alert('登录成功成功!');window.location.href='index.jsp'</script>");
        }else {
            PrintWriter out = resp.getWriter();
            out.print("<script>alert('用户名或密码错误!');window.location.href='login.jsp'</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
