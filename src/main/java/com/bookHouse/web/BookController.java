package com.bookHouse.web;


import com.bookHouse.api.BookService;
import com.bookHouse.api.EvaluationService;
import com.bookHouse.api.UserService;
import com.bookHouse.domain.*;
import com.bookHouse.domain.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.jca.cci.object.MappingRecordOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private EvaluationService evaluationService;


    @RequestMapping("/upload")
    public ModelAndView bookUpload(BookWithFile bookinfo,HttpServletRequest request){
        ModelAndView mv=new ModelAndView();
        bookService.uploadBook(bookinfo,request);
        return mv;
    }

    @RequestMapping("/detail")
    public ModelAndView getDetail(int id){
        ModelAndView mv=new ModelAndView();
        Book book=bookService.selectDetailById(id);
        List<Evaluation> evalist=evaluationService.selectByBookId(id);
        mv.addObject("book",book);
        mv.addObject("evalist",evalist);
        mv.setViewName("/book_detail");
        return mv;
    }

    @RequestMapping("/download")
    public void download(int bookId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //checkPay.apk为需要下载的文件
        //String filename = "checkPay.apk";   //我这里使用的是一个固定的文件，方法可以不用写filename参数
        //获取文件的绝对路径名称，apk为根目录下的一个文件夹，这个只能获取根目录文件夹的绝对路径
        Book book=bookService.selectDetailById(bookId);
        String path =book.getBookAddress() ;
        System.out.println(path);
        //得到要下载的文件
        File file = new File(path);
        if (!file.exists()) {
            response.setContentType("text/html; charset=UTF-8");//注意text/html，和application/html
            response.getWriter().print("<html><body><script type='text/javascript'>alert('您要下载的资源已被删除！');</script></body></html>");
            response.getWriter().close();
            System.out.println("您要下载的资源已被删除！！");
            return;
        }
        String extensionname = path.substring(path.lastIndexOf(".") + 1);
        String filename=book.getBookName()+"."+extensionname;
        //转码，免得文件名中文乱码
        filename = URLEncoder.encode(filename,"UTF-8");
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        // 读取要下载的文件，保存到文件输入流
        FileInputStream in = new FileInputStream(path);
        // 创建输出流
        OutputStream out = response.getOutputStream();
        // 创建缓冲区
        byte buffer[] = new byte[1024]; // 缓冲区的大小设置是个迷  我也没搞明白
        int len = 0;
        //循环将输入流中的内容读取到缓冲区当中
        while((len = in.read(buffer)) > 0){
            out.write(buffer, 0, len);
        }
        //关闭文件输入流
        in.close();
        // 关闭输出流
        out.close();
    }
    @RequestMapping("/managerllbooks")
    public ModelAndView allBooksForManager(){
        ModelAndView mv=new ModelAndView();
        bookService.selectAllBooks();
        return mv;
    }

    @RequestMapping("/searchByKeyword")
    public ModelAndView searchByKeyword(String keyword,int page,int pageSize){
        ModelAndView mv=new ModelAndView();
        int startnumber=(page-1)*pageSize;
        Map<String,Object> condition=new HashMap<String,Object>();
        condition.put("keyword",keyword);
        condition.put("start",startnumber);
        condition.put("limit",pageSize);
        List<Book> bookresult= bookService.selectByConditionWithPage(condition);
        mv.addObject("result",bookresult);
        mv.addObject("currentPage",page);
        mv.addObject("pageSize",pageSize);
        mv.setViewName("bookresult");
        return mv;
    }

    @RequestMapping("/managedetail")
    public ModelAndView getDetailforManager(int id){
        ModelAndView mv=new ModelAndView();
        Book book=bookService.selectDetailById(id);
        mv.addObject("book",book);
        mv.setViewName("/book_detail");
        return mv;
    }

    @RequestMapping("/searchByCategory")
    public ModelAndView searchByCategory(int page,int pageSize,int categoryId){
        ModelAndView mv=new ModelAndView();
        int startnumber=(page-1)*pageSize;
        Map<String,Object> condition=new HashMap<String,Object>();
        condition.put("categoryid",categoryId);
        condition.put("start",startnumber);
        condition.put("limit",pageSize);
        List<Book> bookresult= bookService.selectByConditionWithPage(condition);
        mv.addObject("result",bookresult);
        mv.addObject("currentPage",page);
        mv.addObject("pageSize",pageSize);
        mv.setViewName("searchByCateggoryResult");
        return mv;
    }
    @RequestMapping("/ownCollection")
    public ModelAndView ownCollection(int page,int pageSize,HttpServletRequest request){
        ModelAndView mv=new ModelAndView();
        int userId=Integer.parseInt(request.getSession().getAttribute("userId").toString());
        Map<String,Object> condition=new HashMap<String,Object>();
        int start=(page-1)*pageSize;
        condition.put("limit",pageSize);
        condition.put("start",start);
        condition.put("userId",userId);
        List<Book> booklist=bookService.selectBookByCollectionWithPage(condition);
        mv.addObject("booklist",booklist);
        mv.setViewName("mycollection");
        return mv;
    }

    @RequestMapping("/update")
    public ModelAndView update (Book book,HttpServletRequest request){
        ModelAndView mv=new ModelAndView();
        bookService.updateBookById(book);
        return mv;
    }


}