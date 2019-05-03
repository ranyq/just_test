package com.bookHouse.service;

import com.bookHouse.api.BookService;
import com.bookHouse.api.CategoryService;
import com.bookHouse.dao.CategoryMapper;
import com.bookHouse.domain.Book;
import com.bookHouse.domain.BookWithFile;
import com.bookHouse.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
   private CategoryMapper categoryMapper;

    public String uploadbook(BookWithFile bookWithFile){
        uploadBookCover(bookWithFile);
        uploadBookContent(bookWithFile);
        String result="";
        return result;
    }

    @Override
    public String uploadBookCover(BookWithFile bookWithFile){
        //保存数据库的路径
        String sqlPath = null;
        //定义文件保存的本地路径
        String localPath="D:\\File\\";
        //定义 文件名
        String filename=null;
        if(!bookWithFile.getCover().isEmpty()){
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType=bookWithFile.getCover().getContentType();
            //获得文件后缀名
            String suffixName=contentType.substring(contentType.indexOf("/")+1);
            //得到 文件名
            filename=uuid+"."+suffixName;
            System.out.println(filename);
            //文件保存路径
            File dir=new File(localPath,filename);
               try{ bookWithFile.getCover().transferTo(dir);}
               catch(Exception e){

               }
        }
        return "";
    }

    public String uploadBookContent(BookWithFile bookWithFile){
        return "";
    }

}