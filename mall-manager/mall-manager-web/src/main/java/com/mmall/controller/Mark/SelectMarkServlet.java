package com.mmall.controller.Mark;

import com.mall.service.MarkService;
import com.mall.service.impl.MarkServiceImpl;
import com.mall.service.markAndclass.Mark;

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
        String ppmch=req.getParameter("searchName");

        MarkService productService=new MarkServiceImpl();
        List<Mark> markList=null;
        markList=productService.selectMarkByNameService(ppmch);

        req.setAttribute("markList",markList);
        req.getRequestDispatcher("品牌查删改.jsp").forward(req,resp);
    }

    private void selectAllMark(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<Mark> markList=null;
        MarkService productService=new MarkServiceImpl();
        markList=productService.selectAllService();
        req.setAttribute("markList",markList);
        req.getRequestDispatcher("品牌查删改.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
