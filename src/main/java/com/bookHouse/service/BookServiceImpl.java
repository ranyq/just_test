package com.bookHouse.service;

import com.bookHouse.api.BookService;
import com.bookHouse.api.CategoryService;
import com.bookHouse.dao.BookMapper;
import com.bookHouse.dao.CategoryMapper;
import com.bookHouse.dao.CollectionMapper;
import com.bookHouse.domain.Book;
import com.bookHouse.domain.BookWithFile;
import com.bookHouse.domain.Category;
import com.bookHouse.domain.Collection;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
   private CategoryMapper categoryMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private CollectionMapper collectionMapper;

    public void uploadBook(BookWithFile bookWithFile,HttpServletRequest request){
        String bookCoverAddress=uploadBookCover(bookWithFile,request);
        String bookContentAddress=uploadBookContent(bookWithFile,request);
        Book book=bookWithFile;
        book.setBookAddress(bookContentAddress);
        book.setCoverAddress(bookCoverAddress);
        bookMapper.insertSelective(book);
    }

    @Override
    public String uploadBookCover(BookWithFile bookWithFile,HttpServletRequest requesst){
        String resultmap="";
        //相对路径
        //String realPath=request.getSession().getServletContext().getRealPath("/images/bookcover");
        //定义文件保存的本地路径
        String localPath="E:\\personalidea\\upload\\images\\bookcover\\";
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
               try{ bookWithFile.getCover().transferTo(dir);
                   resultmap=dir.getCanonicalPath();
               }
               catch(Exception e){

               }
        }
        return  resultmap;
    }

    @Override
    public String uploadBookContent(BookWithFile bookWithFile,HttpServletRequest request){
        String resultpath="";
        //相对路径
        //String realPath=request.getSession().getServletContext().getRealPath("/images/bookcover");
        //定义文件保存的本地路径
        String localPath="E:\\personalidea\\upload\\books\\txt\\";
        //定义 文件名
        String filename=null;
        if(!bookWithFile.getBookText().isEmpty()){
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType=bookWithFile.getBookText().getContentType();
            //获得文件后缀名
            //String suffixName=contentType.substring(contentType.indexOf("/")+1);
            String extensionname = bookWithFile.getBookText().getOriginalFilename().substring(bookWithFile.getBookText().getOriginalFilename().lastIndexOf(".") + 1);
            //得到 文件名
            //filename=uuid+"."+suffixName;
            filename=uuid+"."+extensionname;
            System.out.println(filename);
            //文件保存路径
            File file=new File(localPath,filename);
            File dir=new File(localPath);
//            File file=new File(realPath,filename);
//            File dir=new File(realPath);
            try{
            if(dir.exists()){
              }else{
                dir.mkdirs();}
                bookWithFile.getBookText().transferTo(file);
                resultpath=file.getCanonicalPath();
                       }
            catch(Exception e){

            }
        }
        return resultpath;
    }

    public Book selectDetailById(int id){
        return bookMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Book> selectAllBooks() {
        return bookMapper.selectAllBooks();
    }

    @Override
    public List<Book> selectByConditionWithPage(Map<String,Object> condition){
        return bookMapper.selectByConditionWithPage(condition);

    }
    public List<Book> selectOrderByCreatetime(int start,int amount){
        return bookMapper.selectOrderByCreatetime(start,amount);

    }
    public List<Book> selectOrderByDownload(int start,int amount){
       return bookMapper.selectOrderByDownload(start,amount);
    }

    public  List<Book> selectBookByIds(List<Integer> idlist){
        return bookMapper.selectByIds(idlist);
    }

    public List<Book> selectBookByCollectionWithPage(Map<String,Object> param){
        List<Collection> collectionList=collectionMapper.selectByConditionWithPage(param);
        List bookIdList=new ArrayList(){};
        for(int i=0;i<=collectionList.size();i++){
            bookIdList.add(collectionList.get(i).getBookId());
        }
        return bookMapper.selectByIds(bookIdList);
    }

    public int deleteBookById(int id){
        return bookMapper.logicalDeleteBookById(id);


    }

    public int updateBookById(Book book){
        return bookMapper.updateByPrimaryKeySelective(book);
    }
}