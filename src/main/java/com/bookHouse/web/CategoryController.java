package com.bookHouse.web;


import com.bookHouse.api.BookService;
import com.bookHouse.api.CategoryService;
import com.bookHouse.domain.Book;
import com.bookHouse.domain.BookWithFile;
import com.bookHouse.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/categorys")
public class CategoryController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/add")
    public ModelAndView addCategory(String parentId,String categoryName){
        int parent=0;
        int level=0;
        if(parentId!=null&&!parentId.equals("")){
            parent=Integer.parseInt(parentId);
            level=2;
        }else{
            level=1;
        }
        Category category=new Category();
        category.setParentId(parent);
        category.setCategoryName(categoryName);
        category.setDr("0");
        category.setLevel(level);
        categoryService.addCategory(category);
        ModelAndView mv=new ModelAndView("redirect:/manage/managecategory");
        return mv;
    }

    @RequestMapping ("/delete")
    public  ModelAndView delete(int id){
        ModelAndView mv=new ModelAndView();
        Map<String,Object> condition=new HashMap<String,Object>();
        condition.put("categoryid",id);
       List<Book> booklist=bookService.selectByConditionWithPage(condition);
        if(booklist.size()>0){
            mv = new ModelAndView("redirect:/manage/managecategory");

        }else {
            categoryService.deleteById(id);
            mv = new ModelAndView("redirect:/manage/managecategory");
        }
        return mv;
    }

}