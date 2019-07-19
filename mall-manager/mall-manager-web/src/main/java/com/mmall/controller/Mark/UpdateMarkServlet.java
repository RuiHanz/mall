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
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/updateMark.do")
public class UpdateMarkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        String handle=req.getParameter("handle");
        switch (handle) {
            case "update":
                try {
                    updateMark(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteMark(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    private void deleteMark(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        String pp_id = req.getParameter("pp_id");
        MarkService markService=new MarkServiceImpl();
        Integer i = 0;
        i=markService.deleteMarkByIdService(pp_id);
        if (i==1){
            PrintWriter out = resp.getWriter();
            out.print("<script>alert('删除成功!');window.location.href='品牌查删改.jsp';</script>");
            List<Mark> markList=null;
            MarkService productService=new MarkServiceImpl();
            markList=productService.selectAllService();
            req.setAttribute("markList",markList);
            req.getRequestDispatcher("品牌查删改.jsp").forward(req,resp);
        }else {
            PrintWriter out = resp.getWriter();
            out.print("<script>alert('删除失败!');window.location.href='品牌查删改.jsp';</script>");
        }

    }

    private void updateMark(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String pp_id = req.getParameter("pp_id");
        List<String> list=new ArrayList<String>();
        list.add(pp_id);
        MarkService markService=new MarkServiceImpl();
        List<Mark> markList=null;
        markList=markService.selectMarkByIdService(pp_id);

        req.setAttribute("markList",markList);
        req.setAttribute("id",list);
        req.getRequestDispatcher("品牌修改页面2.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
