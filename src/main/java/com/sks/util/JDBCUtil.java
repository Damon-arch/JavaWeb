package com.sks.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
    private static final Logger logger = LogManager.getLogger(JDBCUtil.class);
    // 数据库连接信息
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/javaweb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    // 加载数据库驱动
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage(), e.getCause());
            throw new RuntimeException(e);
        }
    }

    // 获取数据库连接
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            logger.error("Failed to get database connection.");
            throw new RuntimeException(e);
        }
    }

    // 关闭资源
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("Failed to close connection.");
                throw new RuntimeException(e);
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                logger.error("Failed to close preparedStatement.");
                throw new RuntimeException(e);
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                logger.error("Failed to close resultSet.");
                throw new RuntimeException(e);
            }
        }
    }
}
