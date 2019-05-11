package com.bookHouse.api;

import com.bookHouse.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    int insertUser(User user);
    Boolean login(String username,String password);
     List<User> selectUserByKeywordWitPage(Map<String,Object> param);
     User selectById(int id);
     int deleteByUserId(int id);
     int updateByUserId(User user);
    int selectByUserName(String username);
}