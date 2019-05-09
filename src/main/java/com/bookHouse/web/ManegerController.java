package com.bookHouse.web;


import com.bookHouse.api.BookService;
import com.bookHouse.api.CategoryService;
import com.bookHouse.api.UserService;
import com.bookHouse.domain.Book;
import com.bookHouse.domain.Category;
import com.bookHouse.domain.Evaluation;
import com.bookHouse.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/manage")
public class ManegerController {
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BookService bookService;
    @RequestMapping("/managecategory")
    public ModelAndView showcategory(){
        ModelAndView mv=new ModelAndView();
        List<Category> allCategory= categoryService.selectAllCategory();
        List<Category> parentCategory=new ArrayList<Category>();
        for (Category categoeryone:allCategory) {
            if(categoeryone.getLevel()==1){
                parentCategory.add(categoeryone);
            }
        }
        mv.addObject("ALL_CATEGORY",allCategory);
        mv.addObject("PARENT_CATEGORY",parentCategory);
        mv.setViewName("category_manage");
        return mv;
    }

    @RequestMapping("/manageuser")
    public ModelAndView manageUser(int page,int pageSize){
        ModelAndView mv=new ModelAndView();
        int start=(page-1)*pageSize;
        Map<String,Object> param=new HashMap<String,Object>();
        param.put("start",start);
        param.put("limit",pageSize);
        List<User> userlist=userService.selectUserByKeywordWitPage(param);
        mv.addObject("userlist",userlist);
        mv.setViewName("user_manage");
        return mv;
    }
    @RequestMapping("/managebook")
    public ModelAndView manageBook(int page,int pageSize){
        ModelAndView mv=new ModelAndView();
        int start=(page-1)*pageSize;
        Map<String,Object> param=new HashMap<String,Object>();
        param.put("start",start);
        param.put("limit",pageSize);
        List<Book> booklist=bookService.selectByConditionWithPage(param);
        mv.addObject("booklist",booklist);
        mv.setViewName("book_manage");
        return mv;
    }

    @RequestMapping("/deleteUser")
    public ModelAndView deleteUser(int userId){
        ModelAndView mv=new ModelAndView();
        userService.deleteByUserId(userId);
        mv=new ModelAndView("redirect:/manage/manageuser?page=1&&pageSize=20");
        return mv;
    }

    @RequestMapping("/deleteBook")
    public ModelAndView deleteBook(int bookId){
        ModelAndView mv=new ModelAndView();
        bookService.deleteBookById(bookId);
        mv=new ModelAndView("redirect:/manage/managebookr?page=1&&pageSize=20");
        return mv;
    }


    @RequestMapping("/toUpdateBookById")
    public ModelAndView toUpdateBookById(int bookId){
        ModelAndView mv=new ModelAndView();
        Book book=bookService.selectDetailById(bookId);
        List<Category> categoryList=categoryService.selectAllCategory();
        mv.addObject("book",book);
        mv.addObject("category",categoryList);
        mv.setViewName("/book_update");
        return mv;
    }

    @RequestMapping("/showbookdetail")
    public ModelAndView showbookdetail(int bookId){
        ModelAndView mv=new ModelAndView();
        Book book=bookService.selectDetailById(bookId);
        mv.addObject("book",book);
        mv.setViewName("/book_detail_forman");
        return mv;
    }


}