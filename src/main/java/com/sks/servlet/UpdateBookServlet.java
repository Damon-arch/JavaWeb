package com.sks.servlet;

import com.sks.constant.ExceptionMsgConstant;
import com.sks.dao.BookDao;
import com.sks.dao.BookDaoImpl;
import com.sks.entity.Book;
import com.sks.util.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        BookDao bookDao = new BookDaoImpl();
        int i = bookDao.updateBook(new Book(id, name, author));
        if (i > 0) {
            ServletUtil.selectAfterUpdate(req, resp, bookDao);
        } else {
            throw new RuntimeException(ExceptionMsgConstant.UPDATE_BOOK_FAIL);
        }
    }
}
