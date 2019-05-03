package com.bookHouse.api;

import com.bookHouse.domain.Category;
import com.bookHouse.domain.User;

import java.util.List;

public interface CategoryService {
    public List<Category> selectAllCategory();

}