package com.bookHouse.web;


import com.bookHouse.api.BookService;
import com.bookHouse.api.UserService;
import com.bookHouse.domain.BookWithFile;
import com.bookHouse.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/upload")
    public ModelAndView upload(BookWithFile bookinfo){
        ModelAndView mv=new ModelAndView();
        bookService.uploadBookCover(bookinfo);
        return mv;
    }
}