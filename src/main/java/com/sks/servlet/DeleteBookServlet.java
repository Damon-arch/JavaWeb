package com.sks.servlet;

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
import java.util.List;

public class DeleteBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("bookId"));
        BookDao bookDao = new BookDaoImpl();
        int i = bookDao.deleteBook(id);
        if (i > 0) {
            List<Book> books;
            try {
                books = bookDao.selectAll();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            req.setAttribute("bookList", books);
            req.getRequestDispatcher(PathUtil.getPath("main")).forward(req, resp);
        } else {
            throw new RuntimeException("删除书籍失败");
        }
    }
}