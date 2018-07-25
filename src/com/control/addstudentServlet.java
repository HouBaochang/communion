package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BaseDAO;

public class addstudentServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
        String sno=request.getParameter("sno");
      int sn= Integer.parseInt(sno);
        String spsw=request.getParameter("spsw");
        String sname=request.getParameter("sname");
       String Sname=new String(sname.getBytes("iso-8859-1"),"utf-8");
        System.out.println(sno);
        //调用DAO层
        BaseDAO dao=new BaseDAO();
        boolean status=dao.addOne(sno,spsw,Sname);
        //设置Servlet返回数据的编码为“UTF-8”
        System.out.println("张三");
        
		PrintWriter out = response.getWriter();
        if(status==true){
        	out.println("1");
        }else{
        	out.println("0");
        }
		out.flush();
		out.close();
	
	
		 //调用doPost方法进行处理
		
	}
	//处理POST请求的方法（实现新闻内容的保存）
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		}
	}


