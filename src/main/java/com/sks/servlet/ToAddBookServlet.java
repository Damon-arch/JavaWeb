package com.sks.servlet;

import com.sks.constant.JspNameConstant;
import com.sks.util.PathUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ToAddBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(PathUtil.getPath(JspNameConstant.ADD_BOOK)).forward(req, resp);
    }
}
