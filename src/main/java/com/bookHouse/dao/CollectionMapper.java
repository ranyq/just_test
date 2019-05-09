package com.bookHouse.dao;

import com.bookHouse.domain.Collection;

import java.util.List;
import java.util.Map;

public interface CollectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collection record);

    int insertSelective(Collection record);

    Collection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Collection record);

    int updateByPrimaryKey(Collection record);

    List<Collection> selectByCondition(Collection collection);

    List<Collection> selectByConditionWithPage(Map<String,Object> param);
}