package com.bookHouse.service;

import com.bookHouse.api.EvaluationService;
import com.bookHouse.api.UserService;
import com.bookHouse.dao.EvaluationMapper;
import com.bookHouse.dao.UserMapper;
import com.bookHouse.domain.Evaluation;
import com.bookHouse.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private HttpSession session;
    @Autowired
    private EvaluationMapper evaluationMapper;


    public int insertUser(User user){
        return userMapper.insert(user);
    }
    @Override
    public Boolean login(String username,String password){
        Boolean loginresult=false;
        User user =new User();
        user.setName(username);
        List<User> resultlist=userMapper.selectByCondition(user);
        if(resultlist.size()>0){
        //因为用户名唯一所以list中取唯一的用户
        User result =resultlist.get(0);
        String answer=result.getPassword();
        if(answer.equals(password)){
            loginresult=true;
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession httpSession=request.getSession();
            httpSession.setAttribute("userName",user.getName());
            httpSession.setAttribute("userId",1);
          }
        }
        return loginresult;
    }

    public List<User> selectUserByKeywordWitPage(Map<String,Object> param){
        return userMapper.selectByKeywordWithPage(param);
    }

    @Override
    public User selectById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public int deleteByUserId(int id){
        int result=0;
        User user=new User();
        user.setId(id);
        user.setStatus("2");
        Date deletedate=new Date();
        user.setForzenTime(deletedate);
        int deleteusercount=userMapper.updateByPrimaryKeySelective(user);
        if(deleteusercount>0){
            Evaluation evaluation = new Evaluation();
            evaluation.setUserId(id);
            evaluationMapper.logicalDeleteByCondition(evaluation);
            result=1;
        }
        return result;

    }

    public int updateByUserId(User user){
        return userMapper.updateByPrimaryKeySelective(user);
    }


}