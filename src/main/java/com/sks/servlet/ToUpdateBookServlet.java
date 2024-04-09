package com.sks.servlet;

import com.sks.constant.JspNameConstant;
import com.sks.dao.BookDao;
import com.sks.dao.BookDaoImpl;
import com.sks.entity.Book;
import com.sks.util.PathUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ToUpdateBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        BookDao bookDao = new BookDaoImpl();
        Book book;
        try {
            book = bookDao.getBookById(bookId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("book", book);
        req.getRequestDispatcher(PathUtil.getPath(JspNameConstant.UPDATE_BOOK)).forward(req, resp);
    }
}
