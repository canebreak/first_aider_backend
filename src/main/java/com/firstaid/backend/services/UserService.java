package com.firstaid.backend.services;

import com.firstaid.backend.Model.User;

import java.util.List;

public interface UserService {

    public User login(User user);

    public User register();


}
