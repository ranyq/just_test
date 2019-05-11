package com.bookHouse.dao;

import com.bookHouse.domain.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectByCondition(User user);

    List<User> selectByKeywordWithPage(Map<String,Object> param);

    int countByCondition (User condition);
}