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

public class AddBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        BookDao bookDao = new BookDaoImpl();
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        int i = bookDao.addBook(book);
        if (i > 0) {
            ServletUtil.selectAfterUpdate(req, resp, bookDao);
        } else {
            throw new RuntimeException(ExceptionMsgConstant.ADD_BOOK_FAIL);
        }
    }
}
