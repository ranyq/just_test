package com.bookHouse.web;


import com.bookHouse.api.UserService;
import com.bookHouse.domain.User;
import com.bookHouse.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/register")
    public void register(User user){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date nowtime=new Date();
        user.setCreateTime(nowtime);
        userService.insertUser(user);

    }
    @RequestMapping("/login")
    public ModelAndView login(User user){
        ModelAndView mv=new ModelAndView();
        Boolean result=userService.login(user.getName(),user.getPassword());
        mv.addObject("err_msg","您的用户名不存在或者密码错误，请重新输入");
        mv.setViewName("login");
        return mv;
    }
}