package com.sks.util;

import com.sks.constant.JspNameConstant;
import com.sks.dao.BookDao;
import com.sks.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ServletUtil {
    public static void selectAfterUpdate(HttpServletRequest req, HttpServletResponse resp, BookDao bookDao) throws ServletException, IOException {
        List<Book> books;
        try {
            books = bookDao.selectAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("bookList", books);
        req.getRequestDispatcher(PathUtil.getPath(JspNameConstant.MAIN)).forward(req, resp);
    }
}
