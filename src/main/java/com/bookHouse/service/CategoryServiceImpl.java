package com.bookHouse.service;

import com.bookHouse.api.CategoryService;
import com.bookHouse.api.UserService;
import com.bookHouse.dao.CategoryMapper;
import com.bookHouse.dao.UserMapper;
import com.bookHouse.domain.Category;
import com.bookHouse.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
   private CategoryMapper categoryMapper;

    @Override
    public List<Category> selectAllCategory() {
        return categoryMapper.selectAllCategory();
    }

}