package com.bookHouse.api;

import com.bookHouse.domain.Category;
import com.bookHouse.domain.User;

import java.util.List;

public interface CategoryService {
    List<Category> selectAllCategory();
    String addCategory(Category category);
    int deleteById(int id);

}