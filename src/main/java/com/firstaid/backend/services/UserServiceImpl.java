package com.firstaid.backend.services;

import com.firstaid.backend.Model.User;
import com.firstaid.backend.resource.helper.ResourceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserServiceImpl implements UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User login(User user) {
        String sqlInsertUser = ResourceHelper.getResourceText("sql/add_user.sql");
        jdbcTemplate.update(sqlInsertUser, user.getFirstName(), user.getLastName(), user.getPassword());

        return user;
    }

    @Override
    public User register() {
        return null;
    }
}
