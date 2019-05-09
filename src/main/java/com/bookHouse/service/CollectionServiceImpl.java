package com.bookHouse.service;

import com.bookHouse.api.CollectionService;
import com.bookHouse.api.UserService;
import com.bookHouse.dao.CollectionMapper;
import com.bookHouse.dao.UserMapper;
import com.bookHouse.domain.Collection;
import com.bookHouse.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionMapper collectionMapper;
    @Override
    public void addCollection(Collection collection){
        collectionMapper.insertSelective(collection);
    };

    public List<Collection> selectByCondition(Collection collection){
        return collectionMapper.selectByCondition(collection);
    }

    public List<Collection> selectByConditionWithPage(Map<String,Object> param){
        return collectionMapper.selectByConditionWithPage(param);
    }

    public int deleteCollection(int userId,int bookId){
        int result=0;
        Collection condition=new Collection();
        condition.setUserId(userId);
        condition.setBookId(bookId);
        condition.setDr("0");
        List<Collection> collectionlist=collectionMapper.selectByCondition(condition);
        //因为理论上只有一条
        int collectionid=collectionlist.get(0).getId();
        Collection deletecondition=new Collection();
        deletecondition.setId(collectionid);
        deletecondition.setDr("1");
        result=collectionMapper.updateByPrimaryKey(deletecondition);
        return result;
    }

}