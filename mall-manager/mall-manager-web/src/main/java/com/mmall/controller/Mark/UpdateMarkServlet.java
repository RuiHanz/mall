package com.mmall.controller.Mark;

import com.mall.service.MarkService;
import com.mall.service.impl.MarkServiceImpl;
import com.mall.service.markAndclass.Mark;
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

@WebServlet("/updateMark.do")
public class UpdateMarkServlet extends HttpServlet {
    private MarkService service = new MarkServiceImpl();
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
            //req.getRequestDispatcher("品牌查删改.jsp").forward(req,resp);
        }else {
            PrintWriter out = resp.getWriter();
            out.print("<script>alert('删除失败!');window.location.href='品牌查删改.jsp';</script>");
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



    private void updateMark(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String pp_id = req.getParameter("pp_id");
        String currentPage=req.getParameter("currentPage");

        List<String> list=new ArrayList<String>();
        list.add(pp_id);
        MarkService markService=new MarkServiceImpl();
        List<Mark> markList=null;
        List<String> list1=new ArrayList<String>();

        markList=markService.selectMarkByIdService(pp_id);
        list1.add(currentPage);
        req.setAttribute("currentPage",list1);
        req.setAttribute("markList",markList);
        req.setAttribute("id",list);
        req.getRequestDispatcher("品牌修改页面2.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
