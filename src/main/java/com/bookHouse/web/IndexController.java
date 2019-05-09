package com.bookHouse.web;


import com.bookHouse.api.BookService;
import com.bookHouse.api.CategoryService;
import com.bookHouse.api.UserService;
import com.bookHouse.domain.Book;
import com.bookHouse.domain.Category;
import com.bookHouse.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BookService bookService;
    @RequestMapping("/load")
    public ModelAndView loadIndex(){
        ModelAndView mv=new ModelAndView();
        Map<String,Object> indexmap=new HashMap<String,Object>();
        List<Category> categorylist=categoryService.selectAllCategory();
        List<Book> booklisttime= bookService.selectOrderByCreatetime(0,5);
        List<Book> booklistdown= bookService.selectOrderByDownload(0,5);
        mv.addObject("allCategory",categorylist);
        mv.addObject("bookLisTime",booklisttime);
        mv.addObject("bookListDown",booklistdown);
        mv.setViewName("index");
        return mv;
    }

}