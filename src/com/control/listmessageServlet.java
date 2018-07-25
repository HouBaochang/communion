package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BaseDAO;

public class listmessageServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session=request.getSession();
		 String page=request.getParameter("curpage");
		 //当前页
		 int curpage=1;
		 if(page!=null && !page.equals("")){
			 curpage=Integer.parseInt(page);
		 }
		 request.setAttribute("curpage", curpage);
		 
		 //页大小
		 int pageSize=15;
		 int startIndex=(curpage-1)*pageSize;
		 
	    //进行登录页验证，防止没有登录直接进入此页面
	    /*String tno=(String)session.getAttribute("tno");
	    //String tname=(String)session.getAttribute("tname");
	    //String text=(String)session.getAttribute("text");
	    if(tno!=null && !tno.equals("")){ 
	    	request.setCharacterEncoding("utf-8");//转码
	    	
			 
			 //标题
			 String title=request.getParameter("title");
			 if(title!=null && !title.equals("")){
				
				 request.setAttribute("title", title);
			 }
			 //老师
			 String tname=request.getParameter("tname");
			 if(tname!=null && !tname.equals("")){
				 
				 request.setAttribute("tname", tname);
			 }
			 String text=request.getParameter("text");
			 if(text!=null && !text.equals("")){
				 
				 request.setAttribute("text", text);
			 }*/
			 //调用DAO层
			 BaseDAO dao=new BaseDAO();
			 Map<String,Object> data=dao.getAll("*","message", "", "messageid desc",startIndex,pageSize);	
			 
			 //记录数据
			 List<Map<String,String>> records=(List<Map<String,String>>)data.get("records");
			 
			 //记录总数
			 int totalCount=(Integer)data.get("totalCount");
			 
			 //总页数
			 int totalPage=0;
			 if(totalCount%pageSize==0){
				 totalPage=totalCount/pageSize;
			 }else if(totalCount%pageSize>0){
				 totalPage=totalCount/pageSize+1;
			 }
			 
			 
			 request.setAttribute("curpage", curpage);
			 request.setAttribute("totalPage", totalPage);
			 request.setAttribute("pageSize", pageSize);
			 request.setAttribute("totalCount", totalCount);
			  
			 request.setAttribute("records", records);
	         request.getRequestDispatcher("listmessage.jsp").forward(request, response);	 
	    }
	}


