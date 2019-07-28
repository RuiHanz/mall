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
@WebServlet("/updateMark2.do")
public class UpdateMarkServlet2 extends HttpServlet {
    private MarkService service = new MarkServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String id=req.getParameter("id"); //获取原id
        Mark mark=new Mark();
        mark.setPp_id(req.getParameter("pp_id"));
        mark.setPpmch(req.getParameter("ppmch"));
        mark.setUrl(req.getParameter("url"));
        mark.setFlmch1_id(0);
        MarkService markService=new MarkServiceImpl();
        Integer i=null;
        try {
            i=markService.updateMarkByIdService(mark,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (i==1){
            PrintWriter out = resp.getWriter();
            out.print("<script>alert('删除成功!');window.location.href='品牌查删改.jsp';</script>");
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



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
