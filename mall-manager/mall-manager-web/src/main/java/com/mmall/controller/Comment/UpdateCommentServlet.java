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
import java.io.PrintWriter;
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
        String pl_id = req.getParameter("pl_id");
        ICommentService service = new CommentServiceImpl();
        boolean isSuccess =service.deleteCommentService(pl_id);
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
            service.getAllService(pb);
            //保存域对象
            req.setAttribute("pageBean", pb);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        PrintWriter out = resp.getWriter();
        out.print("<script>alert('删除成功!');window.location.href='评论管理.jsp'</script>");
           /* //跳转
            req.getRequestDispatcher("评论管理.jsp").forward(req, resp);*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
