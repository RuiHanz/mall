package com.mmall.controller.Comment;


import com.mall.service.Comment.Comment;
import com.mall.service.comment.ICommentDao;
import com.mall.service.impl.comment.CommentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/selectComment.do")
public class SelectCommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");


        Integer selecttype = Integer.parseInt(req.getParameter("selectType"));
        System.out.println(selecttype);

        switch (selecttype) {
            case 0:
                try {
                    selectAll(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 1:
                try {
                    selectByShp_id(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    selectByShp_mch(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;


        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void selectByShp_mch(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {

        String shp_mch=req.getParameter("searchName");
        List<Comment> commentsList=null;
        ICommentDao dao=new CommentDaoImpl();
        commentsList=dao.selectByShp_mch(shp_mch);
        req.setAttribute("commentsList",commentsList);
        req.getRequestDispatcher("评论管理.jsp").forward(req,resp);

    }
    private void selectByShp_id(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String shp_id=req.getParameter("searchName");
        List<Comment> commentsList=null;
        ICommentDao dao=new CommentDaoImpl();
        commentsList=dao.getCommentPro(shp_id);
        req.setAttribute("commentsList",commentsList);
        req.getRequestDispatcher("评论管理.jsp").forward(req,resp);
    }



    private void selectAll(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<Comment> commentsList=null;
        ICommentDao dao=new CommentDaoImpl();
        commentsList=dao.sellectAll();
        req.setAttribute("commentsList",commentsList);
        req.getRequestDispatcher("评论管理.jsp").forward(req,resp);
    }

}



