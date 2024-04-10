package com.sks.servlet;

import com.sks.dao.BookDao;
import com.sks.entity.Book;
import com.sks.util.ServletUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDao bookDao = context.getBean("bookDao", BookDao.class);
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        int i = bookDao.addBook(book);
        if (i > 0) {
            ServletUtil.selectAfterUpdate(req, resp, bookDao);
        } else {
            throw new RuntimeException("添加书籍失败");
        }
    }
}
