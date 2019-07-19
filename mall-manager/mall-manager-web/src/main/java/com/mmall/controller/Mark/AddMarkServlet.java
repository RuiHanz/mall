package com.mmall.controller.Mark;

import com.mall.service.MarkService;
import com.mall.service.impl.MarkServiceImpl;
import com.mall.service.markAndclass.Mark;
import com.mall.service.utils.UUIDUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/addMark.do")
public class AddMarkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        UUIDUtils uuidUtils=new UUIDUtils();
        Mark mark=new Mark();
        mark.setPp_id(uuidUtils.getId());
        mark.setPpmch(req.getParameter("ppmch"));
        mark.setFlmch1_id(0);
        mark.setUrl(req.getParameter("url"));
        MarkService markService=new MarkServiceImpl();
        Integer i=null;
        try {
            i=markService.addMarkService(mark);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (i==1){
            PrintWriter out=resp.getWriter();
            out.print("<script>alert('添加成功!');window.location.href='添加品牌.jsp'</script>");
        }else {
            PrintWriter out=resp.getWriter();
            out.print("<script>alert('添加失败!');window.location.href='添加品牌.jsp'</script>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
