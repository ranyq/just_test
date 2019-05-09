package com.bookHouse.api;

import com.bookHouse.domain.Collection;
import com.bookHouse.domain.User;

import java.util.List;
import java.util.Map;

public interface CollectionService {
    void addCollection(Collection collection);
    List<Collection> selectByCondition(Collection collection);
    List<Collection> selectByConditionWithPage(Map<String,Object> param);
    int deleteCollection(int userId,int bookId);
}