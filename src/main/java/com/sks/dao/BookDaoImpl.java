package com.sks.dao;

import com.sks.entity.Book;
import com.sks.util.JDBCUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private static final Logger logger = LogManager.getLogger(BookDaoImpl.class);

    @Override
    public List<Book> selectAll() throws SQLException {
        String sql = "select * from book";
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            logger.error("查询执行失败", e.getCause());
            throw new RuntimeException(e);
        }
        List<Book> bookList = new LinkedList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String author = resultSet.getString("author");
            bookList.add(new Book(id, name, author));
        }
        JDBCUtil.close(connection, preparedStatement, resultSet);
        return bookList;
    }
}
