package com.bookHouse.api;

import com.bookHouse.domain.User;

public interface UserService {
    public void insertUser(User user);
    public Boolean login(String username,String password);
}