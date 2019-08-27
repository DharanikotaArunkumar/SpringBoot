package com.learnjava.service;

import com.learnjava.model.User;

public interface UserService {

    public User findUserByEmail(String email) ;
    public User saveUser(User user);
}
