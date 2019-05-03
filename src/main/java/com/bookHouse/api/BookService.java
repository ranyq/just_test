package com.bookHouse.api;

import com.bookHouse.domain.BookWithFile;
import com.bookHouse.domain.User;

public interface BookService {
    public String uploadBookCover(BookWithFile bookWithFile);
}