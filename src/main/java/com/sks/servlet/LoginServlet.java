package com.sks.servlet;

import com.sks.dao.BookDao;
import com.sks.dao.BookDaoImpl;
import com.sks.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        resp.setContentType("text/html;charset=utf-8");
        if ("admin".equals(username) && "admin".equals(password)) {
            req.getSession().setAttribute("username", username);
            BookDao bookDao = new BookDaoImpl();
            List<Book> books;
            try {
                books = bookDao.selectAll();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            req.setAttribute("bookList", books);
            req.getRequestDispatcher("WEB-INF/jsp/main.jsp").forward(req, resp);
        } else {
            req.setAttribute("msg", "用户名或密码错误");
            req.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(req, resp);
        }
    }
}
