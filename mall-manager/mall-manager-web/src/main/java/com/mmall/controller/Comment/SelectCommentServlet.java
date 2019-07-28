package com.mmall.controller.Comment;


import com.mall.service.Comment.Comment;
import com.mall.service.ICommentService;
import com.mall.service.comment.ICommentDao;
import com.mall.service.impl.CommentServiceImpl;
import com.mall.service.impl.comment.CommentDaoImpl;
import com.mall.service.utils.PageBean;

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
        ICommentService service = new CommentServiceImpl();
        try {
            //获取“当前页”参数(第一次访问时当前页为null)
            String currPage = req.getParameter("currentPage");
            //判断   第一次是设置默认值
            if(currPage == null || "".equals(currPage)){
                currPage = "1";
            }
            //转换   从jsp获取的都是字符串型的    需转换为整形才能保存到javaBean中
            int currentPage = Integer.parseInt(currPage);

            PageBean<Comment> pb = new PageBean<Comment>();
            pb.setCurrentPage(currentPage);

            //调用service层
            try {
                service.selectByShp_mchService(pb,shp_mch);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //保存域对象
            req.setAttribute("pageBean", pb);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        //跳转
        req.getRequestDispatcher("评论管理.jsp").forward(req, resp);

    }
    private void selectByShp_id(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String shp_id=req.getParameter("searchName");
        ICommentService service = new CommentServiceImpl();
        try {
            //获取“当前页”参数(第一次访问时当前页为null)
            String currPage = req.getParameter("currentPage");
            //判断   第一次是设置默认值
            if(currPage == null || "".equals(currPage)){
                currPage = "1";
            }
            //转换   从jsp获取的都是字符串型的    需转换为整形才能保存到javaBean中
            int currentPage = Integer.parseInt(currPage);

            PageBean<Comment> pb = new PageBean<Comment>();
            pb.setCurrentPage(currentPage);

            //调用service层
            try {
                service.selectByShp_id1Service(pb,shp_id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //保存域对象
            req.setAttribute("pageBean", pb);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        //跳转
        req.getRequestDispatcher("评论管理.jsp").forward(req, resp);
    }



    private void selectAll(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        ICommentService service = new CommentServiceImpl();
        try {
            //获取“当前页”参数(第一次访问时当前页为null)
            String currPage = req.getParameter("currentPage");
            //判断   第一次是设置默认值
            if(currPage == null || "".equals(currPage)){
                currPage = "1";
            }
            //转换   从jsp获取的都是字符串型的    需转换为整形才能保存到javaBean中
            int currentPage = Integer.parseInt(currPage);

            PageBean<Comment> pb = new PageBean<Comment>();
            pb.setCurrentPage(currentPage);

            //调用service层
            try {
                service.getAllService(pb);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //保存域对象
            req.setAttribute("pageBean", pb);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        //跳转
        req.getRequestDispatcher("评论管理.jsp").forward(req, resp);
    }

}



