package com.bookHouse.web;


import com.bookHouse.api.CategoryService;
import com.bookHouse.api.UserService;
import com.bookHouse.domain.Category;
import com.bookHouse.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManegerController {
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;
    @RequestMapping("/showcategory")
    public ModelAndView show(){
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
}