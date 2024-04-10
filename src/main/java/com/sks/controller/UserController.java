package com.sks.controller;

import com.sks.entity.User;
import com.sks.mapper.SpringUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private SpringUserMapper springUserMapper;

    @RequestMapping("/userList")
    public String toUserList(HttpServletRequest request) throws SQLException {
        List<User> allUsers = springUserMapper.getAllUsers();
        request.setAttribute("userList", allUsers);
        return "userList";
    }

    @RequestMapping("/toAddUser")
    public String toAddUser() {
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(HttpServletRequest request) throws SQLException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        int i = springUserMapper.addUser(new User(1, name, password));
        if (i > 0) {
            List<User> allUsers = springUserMapper.getAllUsers();
            request.setAttribute("userList", allUsers);
            return "userList";
        } else {
            request.setAttribute("msg", "添加用户失败");
            return "error";
        }
    }

    @RequestMapping("/toUpdateUser")
    private String toUpdateUser(HttpServletRequest request) throws SQLException {
        int id = Integer.parseInt(request.getParameter("userId"));
        User user = springUserMapper.getUser(id);
        request.setAttribute("user", user);
        return "updateUser";
    }

    @RequestMapping("/updateUser")
    public String updateUser(HttpServletRequest request) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        springUserMapper.updateUser(new User(id, name, password));
        List<User> allUsers = springUserMapper.getAllUsers();
        request.setAttribute("userList", allUsers);
        return "userList";
    }

    @RequestMapping("/deleteUser")
    private String deleteUser(HttpServletRequest request) throws SQLException {
        int id = Integer.parseInt(request.getParameter("userId"));
        int i = springUserMapper.deleteUser(id);
        List<User> allUsers = springUserMapper.getAllUsers();
        request.setAttribute("userList", allUsers);
        return "userList";
    }
}
