package com.bookHouse.web;


import com.bookHouse.api.BookService;
import com.bookHouse.api.CollectionService;
import com.bookHouse.domain.Book;
import com.bookHouse.domain.BookWithFile;
import com.bookHouse.domain.Collection;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.apache.ibatis.binding.MapperMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/collection")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private BookService bookService;

    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public Boolean addCollection(@RequestBody Map<String,Object> param, HttpSession session){
        Boolean result=false;
        Collection collection=new Collection();
        int bookId=Integer.parseInt(param.get("bookId").toString());
        String bookName=param.get("bookId").toString();
        collection.setBookId(bookId);
        collection.setBookName(bookName);
        int  userid=Integer.parseInt(session.getAttribute("userId").toString());
        String username=(String)session.getAttribute("userName");
        collection.setUserId(userid);
        collection.setUserName(username);
        collectionService.addCollection(collection);
        return result;
    }

    @RequestMapping("/cancel")
    public ModelAndView cancel(int bookId,HttpServletRequest request){
        int userId=Integer.parseInt(request.getSession().getAttribute("userId").toString());
        collectionService.deleteCollection(userId,bookId);
        ModelAndView mv=new ModelAndView("redirect:/book/ownCollection");
        return mv;
    }

}