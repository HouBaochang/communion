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

public class listwbServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		//调用DAO层
		 BaseDAO dao=new BaseDAO();
		 Map<String,Object> data=dao.getAlls("*","test");	
		 
		 //记录数据
		 List<Map<String,String>> recordss=(List<Map<String,String>>)data.get("recordss");
		 System.out.println(recordss);
		 request.setAttribute("recordss", recordss);
       request.getRequestDispatcher("listwb.jsp").forward(request, response);	 
	}

}
