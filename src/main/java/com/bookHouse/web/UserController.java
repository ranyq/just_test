package com.bookHouse.web;


import com.bookHouse.api.BookService;
import com.bookHouse.api.CollectionService;
import com.bookHouse.api.EvaluationService;
import com.bookHouse.api.UserService;
import com.bookHouse.domain.Book;
import com.bookHouse.domain.Evaluation;
import com.bookHouse.domain.User;
import com.bookHouse.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private BookService bookService;
    @Autowired
    private EvaluationService evaluationService;

    @RequestMapping("/register")
    public ModelAndView register(User user,HttpServletRequest request){
        ModelAndView mv=new ModelAndView();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date nowtime=new Date();
        user.setCreateTime(nowtime);
        user.setStatus("1");
        int result=userService.insertUser(user);
        if(result>=1){
            HttpSession httpSession=request.getSession();
            httpSession.setAttribute("userName",user.getName());
            httpSession.setAttribute("userId",1);
            mv=new  ModelAndView("redirect:/index/load");
        }else{
            mv.addObject("error","因某些原因注册失败，请重新尝试，如不能解决请联系作者");
            mv.setViewName("/register");
        }
        return mv;
    }
    @RequestMapping("/login")
    public ModelAndView login(User user){
        ModelAndView mv=new ModelAndView();
        Boolean result=userService.login(user.getName(),user.getPassword());
        if(result==true){
            mv=new  ModelAndView("redirect:/index/load");
        }else{
        mv.addObject("err_msg","您的用户名不存在或者密码错误，请重新输入");
        mv.setViewName("/login");}
        return mv;
    }
    @RequestMapping("/showdetail")
    public ModelAndView showUserDetail(int userId){
        ModelAndView mv=new ModelAndView();
        User user=userService.selectById(userId);
        mv.addObject("user",user);
        mv.setViewName("/user_detail");
        return mv;
    }
    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request){
        request.getSession().removeAttribute("userId");
        request.getSession().removeAttribute("userName");
        ModelAndView mv=new  ModelAndView("redirect:/index/load");
        return mv;
    }
    @RequestMapping("/toMySpace")
    public ModelAndView toMySpace(HttpServletRequest request){
        ModelAndView mv=new ModelAndView();
        int userId=Integer.parseInt(request.getSession().getAttribute("userId").toString());
        User user=userService.selectById(userId);
        Map<String,Object> condition=new HashMap<String,Object>();
        condition.put("userId",userId);
        condition.put("start",0);
        condition.put("limit",5);
        List<Book> bookList=bookService.selectBookByCollectionWithPage(condition);
        List<Evaluation> evalist=evaluationService.selectByConditionWithPage(condition);
        mv.addObject("user",user);
        mv.addObject("collectbooklist",bookList);
        mv.addObject("evaluationlist",evalist);
        mv.setViewName("/mySpace");
        return mv;
    }

    @RequestMapping("/toedit")
    public ModelAndView toEdit(HttpServletRequest request){
        ModelAndView mv=new ModelAndView();
        int userId=Integer.parseInt(request.getSession().getAttribute("userId").toString());
        User user=userService.selectById(userId);
        mv.addObject("user",user);
        mv.setViewName("/edit_userinfo");
        return mv;
    }

    @RequestMapping("/edit")
    public ModelAndView edit(User user,HttpServletRequest request){
        ModelAndView mv=new ModelAndView();
        int userId=Integer.parseInt(request.getSession().getAttribute("userId").toString());
        user.setId(userId);
        int result=userService.updateByUserId(user);
        mv=new ModelAndView("redirect:/user/toMyspace");
        return mv;
    }

}