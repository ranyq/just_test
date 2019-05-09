package com.bookHouse.web;


import com.bookHouse.api.EvaluationService;
import com.bookHouse.api.UserService;
import com.bookHouse.domain.Evaluation;
import com.bookHouse.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/evaulations")
public class EvaluationController {
    @Autowired
    private EvaluationService evaluationService;
    @RequestMapping("/toAdd")
    public ModelAndView toAdd(int bookId,String bookName){
        ModelAndView mv=new ModelAndView();
        mv.addObject("bookId",bookId);
        mv.addObject("bookName",bookName);
        mv.setViewName("add_evaluation");
        return mv;
    }

    @RequestMapping("/add")
    public ModelAndView add(Evaluation evaluation,HttpServletRequest req){
        ModelAndView mv=new ModelAndView();
        String userName=req.getSession().getAttribute("userName").toString();
        int userId=Integer.parseInt(req.getSession().getAttribute("userId").toString());
        evaluation.setUserId(userId);
        evaluation.setUserName(userName);
        evaluationService.insertEvaluation(evaluation);
        return mv;
    }

    @RequestMapping("/ownEvaluation")
    public ModelAndView toOwnEva (int page,int pageSize,HttpServletRequest req){
        ModelAndView mv=new ModelAndView();
        int userId=Integer.parseInt(req.getSession().getAttribute("userId").toString());
        Map<String,Object> condition=new HashMap<String,Object>();
        int start=(page-1)*pageSize;
        condition.put("userId",userId);
        condition.put("start",start);
        condition.put("limit",pageSize);
        List<Evaluation> evalist=evaluationService.selectByConditionWithPage(condition);
        mv.addObject("evalist",evalist);
        mv.setViewName("/myevaluation");
        return mv;
    }

    @RequestMapping("/delete")
    public ModelAndView delete (int id){
        ModelAndView mv=new ModelAndView();
        Evaluation condition=new Evaluation();
        condition.setDr(1);
        condition.setId(id);
        evaluationService.updateByCondition(condition);
        mv=new ModelAndView("redirect:/evaluation/ownEvaluation?page=1&&pageSize=20");
        return mv;
    }

     @RequestMapping("/toEdit")
    public ModelAndView toEdit(int id){
         ModelAndView mv=new ModelAndView();
         Evaluation eva=evaluationService.selectById(id);
         mv.addObject("eva",eva);
         mv.setViewName("edit_evaluation");
         return mv;
     }

    @RequestMapping("/edit")
    public ModelAndView edit(Evaluation condition){
        ModelAndView mv=new ModelAndView();
        evaluationService.updateByCondition(condition);
        mv=new ModelAndView("/evaluation/ownEvaluation?page=1&&pageSize=20");
        return mv;
    }


}