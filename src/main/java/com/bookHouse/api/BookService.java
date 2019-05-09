package com.bookHouse.api;

import com.bookHouse.domain.Book;
import com.bookHouse.domain.BookWithFile;
import com.bookHouse.domain.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface BookService {
     void uploadBook(BookWithFile bookWithFile,HttpServletRequest request);
     String uploadBookCover(BookWithFile bookWithFile,HttpServletRequest reques);
     String uploadBookContent(BookWithFile bookWithFile,HttpServletRequest reques);
     Book selectDetailById(int id);
     List<Book> selectAllBooks();
     List<Book> selectByConditionWithPage(Map<String,Object> condition);
     List<Book> selectOrderByCreatetime(int start,int amount);
     List<Book> selectOrderByDownload(int start,int amount);
     List<Book> selectBookByIds(List<Integer> idlist);
     List<Book> selectBookByCollectionWithPage(Map<String,Object> param);
     int deleteBookById(int id);
     int updateBookById(Book book);
}