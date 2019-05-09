package com.bookHouse.dao;

import com.bookHouse.domain.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BookMapper {
    int deleteByPrimaryKey(Integer bookId);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> selectByConditionWithPage(Map<String,Object> condition);

    List<Book> selectAllBooks();

    List<Book> selectOrderByCreatetime(@Param("start") int start,@Param("amount") int amount);

    List<Book> selectOrderByDownload(@Param("start") int start,@Param("amount") int amount);

    List<Book> selectByIds(List<Integer> ids);

    int logicalDeleteBookById(int id);
}