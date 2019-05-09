package com.bookHouse.api;

import com.bookHouse.domain.Book;
import com.bookHouse.domain.BookWithFile;
import com.bookHouse.domain.Evaluation;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface EvaluationService {
    void insertEvaluation(Evaluation evaluation);
    List<Evaluation> selectByBookId(int bookid);
    List<Evaluation> selectByConditionWithPage(Map<String,Object> condition);
    int  updateByCondition(Evaluation evaluation);
    Evaluation selectById(int id);
}