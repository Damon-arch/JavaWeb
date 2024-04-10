package com.sks.mapper;

import com.sks.entity.User;
import com.sks.util.JDBCUtil;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository
public class SpringUserMapper {
    public List<User> getAllUsers() throws SQLException {
        String sql = "select * from user";
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> list = new LinkedList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");
            list.add(new User(id, name, password));
        }
        return list;
    }

    public int addUser(User user) throws SQLException {
        String sql = "insert into user (name, password) values (?, ?)";
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, user.getName());
        ps.setString(2, user.getPassword());
        return ps.executeUpdate();
    }

    public User getUser(int id) throws SQLException {
        String sql = "select * from user where id = ?";
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        User user = new User();
        if (rs.next()) {
            String name = rs.getString("name");
            String password = rs.getString("password");
            user.setName(name);
            user.setPassword(password);
            user.setId(id);
        }
        return user;
    }

    public int updateUser(User user) throws SQLException {
        String sql = "update user set name = ?, password = ? where id = ?";
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, user.getName());
        ps.setString(2, user.getPassword());
        ps.setInt(3, user.getId());
        return ps.executeUpdate();
    }

    public int deleteUser(int id) throws SQLException {
        String sql = "delete from user where id = ?";
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate();
    }
}
