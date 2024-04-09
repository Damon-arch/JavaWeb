package com.sks.servlet;

import com.sks.constant.JspNameConstant;
import com.sks.dao.BookDao;
import com.sks.dao.BookDaoImpl;
import com.sks.util.PathUtil;
import com.sks.util.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("1".equals(username) && "1".equals(password)) {
            req.getSession().setAttribute("username", username);
            BookDao bookDao = new BookDaoImpl();
            ServletUtil.selectAfterUpdate(req, resp, bookDao);
        } else {
            req.setAttribute("msg", "用户名或密码错误");
            req.getRequestDispatcher(PathUtil.getPath(JspNameConstant.ERROR)).forward(req, resp);
        }
    }
}
