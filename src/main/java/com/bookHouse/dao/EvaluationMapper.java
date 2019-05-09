package com.bookHouse.dao;

import com.bookHouse.domain.Evaluation;

import java.util.List;
import java.util.Map;

public interface EvaluationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Evaluation record);

    int insertSelective(Evaluation record);

    Evaluation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Evaluation record);

    int updateByPrimaryKey(Evaluation record);

    List<Evaluation> selectByBookId(int id);

    List<Evaluation> selectByConditionWithPage(Map<String,Object> condition);

    int logicalDeleteByCondition(Evaluation condition);
}