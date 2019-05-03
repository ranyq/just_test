package com.bookHouse.service;

import com.bookHouse.api.UserService;
import com.bookHouse.dao.UserMapper;
import com.bookHouse.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    public void insertUser(User user){
        userMapper.insert(user);
    }
    @Override
    public Boolean login(String username,String password){
        Boolean loginresult=false;
        User user =new User();
        user.setName(username);
        List<User> resultlist=userMapper.selectByCondition(user);
        if(resultlist.size()>0){
        //因为用户名唯一所以list中取唯一的用户
        User result =resultlist.get(0);
        String answer=result.getPassword();
        if(answer.equals(password)){
            loginresult=true;
        }
        }
        return loginresult;
    }

}