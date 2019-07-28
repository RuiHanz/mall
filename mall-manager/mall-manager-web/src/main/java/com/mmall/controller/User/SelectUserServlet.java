package com.mmall.controller.User;

import com.mall.service.UserService;
import com.mall.service.impl.UserServiceImpl;
import com.mall.service.product.Product1;
import com.mall.service.user.User;
import com.mall.service.utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/selectUser.do")
public class SelectUserServlet extends HttpServlet {
    private UserService service = new UserServiceImpl();
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
            service.getByYh_shjhService(pb,yh_shjh);

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

    private void selectUserByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String yh_mch=req.getParameter("searchName");
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
            service.getByYh_mchService(pb,yh_mch);

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

    private void selectAllUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<User> userList=null;
//        UserService userService=new UserServiceImpl();
//        userList=userService.selectAllService();
//        req.setAttribute("userList",userList);
//        req.getRequestDispatcher("用户搜删改.jsp").forward(req,resp);
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
