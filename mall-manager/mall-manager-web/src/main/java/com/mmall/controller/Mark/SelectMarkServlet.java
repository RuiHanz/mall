package com.mmall.controller.Mark;

import com.mall.service.MarkService;
import com.mall.service.UserService;
import com.mall.service.impl.MarkServiceImpl;
import com.mall.service.impl.UserServiceImpl;
import com.mall.service.markAndclass.Mark;
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

@WebServlet("/selectMark.do")
public class SelectMarkServlet extends HttpServlet {
    private MarkService service = new MarkServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        Integer selecttype = Integer.parseInt(req.getParameter("selectType"));
        System.out.println(selecttype);
        switch (selecttype){
            case 0:
                try {
                    selectAllMark(req,resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 1:
                try {
                    selectMarkByName(req,resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void selectMarkByName(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String ppmch = req.getParameter("searchName");
        try {
            //获取“当前页”参数(第一次访问时当前页为null)
            String currPage = req.getParameter("currentPage");

            //判断   第一次是设置默认值
            if (currPage == null || "".equals(currPage)) {
                currPage = "1";
            }

            //转换   从jsp获取的都是字符串型的    需转换为整形才能保存到javaBean中
            int currentPage = Integer.parseInt(currPage);

            PageBean<Mark> pb = new PageBean<Mark>();
            pb.setCurrentPage(currentPage);

            //调用service层
            service.getByPpmchService(pb, ppmch);

            //保存域对象
            req.setAttribute("pageBean", pb);


        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //跳转
        req.getRequestDispatcher("品牌查删改.jsp").forward(req, resp);

    }

    private void selectAllMark(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
//        List<Mark> markList=null;
//        MarkService productService=new MarkServiceImpl();
//        markList=productService.selectAllService();
//        req.setAttribute("markList",markList);
//        req.getRequestDispatcher("品牌查删改.jsp").forward(req,resp);
        try {
            //获取“当前页”参数(第一次访问时当前页为null)
            String currPage = req.getParameter("currentPage");

            //判断   第一次是设置默认值
            if(currPage == null || "".equals(currPage)){
                currPage = "1";
            }

            //转换   从jsp获取的都是字符串型的    需转换为整形才能保存到javaBean中
            int currentPage = Integer.parseInt(currPage);

            PageBean<Mark> pb = new PageBean<Mark>();
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
        req.getRequestDispatcher("品牌查删改.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
