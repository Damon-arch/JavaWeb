package com.sks.dao;

import com.sks.entity.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    List<Book> selectAll() throws SQLException;
}
