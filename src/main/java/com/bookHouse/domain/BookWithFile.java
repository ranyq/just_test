package com.bookHouse.domain;

import org.springframework.web.multipart.MultipartFile;

public class BookWithFile extends Book {
    private MultipartFile cover;
    private MultipartFile bookText;

    public MultipartFile getCover() {
        return cover;
    }

    public void setCover(MultipartFile cover) {
        this.cover = cover;
    }

    public MultipartFile getBookText() {
        return bookText;
    }

    public void setBookText(MultipartFile bookText) {
        this.bookText = bookText;
    }
}