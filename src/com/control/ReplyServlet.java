package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BaseDAO;

public class ReplyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String titleid=request.getParameter("titleid");
//		 System.out.print(lyid);
		 BaseDAO dao= new  BaseDAO();
		 List<Map<String,Object>> list=dao.getLY(titleid);	 
		 response.setContentType("text/html;charset=utf-8");
		 request.setAttribute("list", list);
//		 System.out.print(list.size());
		 request.getRequestDispatcher("replywrite.jsp").forward(request, response);
		 }
	}


