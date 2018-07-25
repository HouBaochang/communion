package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BaseDAO;

public class updatestupswServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String newpsw=request.getParameter("newpsw");
		String oldpsw=request.getParameter("oldpsw");
		System.out.println(oldpsw);
		System.out.println(newpsw);
		  if(oldpsw!=null && !oldpsw.equals("")){
	    	// request.setCharacterEncoding("utf-8");
	    	// String newpsw=request.getParameter("newpsw");
			HttpSession session=request.getSession();
	        String studentid=(String)session.getAttribute("studentid");	 
	        System.out.println(studentid);
	    	// String oldpsw=request.getParameter("oldpsw");
	         BaseDAO dao=new BaseDAO();		
			boolean status=dao.updateOne("student","spsw='"+newpsw+"' where studentid="+studentid); 	      
	      PrintWriter out=response.getWriter();
	      if(status==true){
	    	  out.println("1");
	      }
	      else{
	    	  out.println("0");
	      }
		    out	.flush();
		    out.close();    	
	    }
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
	}

