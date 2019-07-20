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

@WebServlet("/updateComment.do")
public class UpdateCommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        String handle=req.getParameter("handle");
        switch (handle){
            case "delete":
                try {
                    deleteComment(req,resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;


        }

    }

    private void deleteComment(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String shp_id = req.getParameter("pl_id");
        ICommentDao dao=new CommentDaoImpl();
        dao.delComment(shp_id);

        List<Comment> commentsList=null;
        commentsList=dao.sellectAll();
        req.setAttribute("commentsList",commentsList);
        req.getRequestDispatcher("评论管理.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
