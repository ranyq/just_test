package com.bookHouse.service;

import com.bookHouse.api.BookService;
import com.bookHouse.api.EvaluationService;
import com.bookHouse.dao.BookMapper;
import com.bookHouse.dao.CategoryMapper;
import com.bookHouse.dao.EvaluationMapper;
import com.bookHouse.domain.Book;
import com.bookHouse.domain.BookWithFile;
import com.bookHouse.domain.Evaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class EvaluationServiceImpl implements EvaluationService {
    @Autowired
    private EvaluationMapper evaluationMapper;

    @Override
    public void insertEvaluation(Evaluation evaluation) {
        evaluationMapper.insertSelective(evaluation);
    }

    @Override
    public List<Evaluation> selectByBookId(int bookid) {
        return evaluationMapper.selectByBookId(bookid);
    }

    public List<Evaluation> selectByConditionWithPage(Map<String,Object> condition){
        return evaluationMapper.selectByConditionWithPage(condition);
    }

    public int  updateByCondition(Evaluation evaluation){
        return evaluationMapper.updateByPrimaryKeySelective(evaluation);
    }

    public Evaluation selectById(int id){
        return evaluationMapper.selectByPrimaryKey(id);
    }
}