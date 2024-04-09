package com.sks.servlet;

import com.sks.constant.ExceptionMsgConstant;
import com.sks.dao.BookDao;
import com.sks.dao.BookDaoImpl;
import com.sks.util.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("bookId"));
        BookDao bookDao = new BookDaoImpl();
        int i = bookDao.deleteBook(id);
        if (i > 0) {
            ServletUtil.selectAfterUpdate(req, resp, bookDao);
        } else {
            throw new RuntimeException(ExceptionMsgConstant.DEL_BOOK_FAIL);
        }
    }


}
