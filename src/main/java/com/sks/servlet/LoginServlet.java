package com.sks.servlet;

import com.sks.constant.JspNameConstant;
import com.sks.dao.BookDao;
import com.sks.dao.BookDaoImpl;
import com.sks.mapper.UserMapper;
import com.sks.util.MybatisUtil;
import com.sks.util.PathUtil;
import com.sks.util.ServletUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            String passwordByName = mapper.getPasswordByName(username);
            if (Objects.equals(passwordByName, password)) {
                req.getSession().setAttribute("username", username);
                BookDao bookDao = new BookDaoImpl();
                ServletUtil.selectAfterUpdate(req, resp, bookDao);
            } else {
                req.setAttribute("msg", "用户名或密码错误");
                req.getRequestDispatcher(PathUtil.getPath(JspNameConstant.ERROR)).forward(req, resp);
            }
        }
    }
}
