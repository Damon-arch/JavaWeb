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

    @Override
    public Book getBookById(int id) throws SQLException {
        String sql = "select * from book where id = ?";
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            logger.error("通过id查询执行失败", e.getCause());
            throw new RuntimeException(e);
        }
        Book book = new Book();
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String author = resultSet.getString("author");
            book.setName(name);
            book.setAuthor(author);
        }
        book.setId(id);
        return book;
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update book set name = ?, author = ? where id = ?";
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setInt(3, book.getId());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteBook(int id) {
        String sql = "delete from book where id = ?";
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int addBook(Book book) {
        String sql = "insert into book (name, author) VALUES (?, ?)";
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getAuthor());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
