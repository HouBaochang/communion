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

public class listwbsServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//接受管理员端发送到url
		String types=request.getParameter("types");
		BaseDAO dao= new BaseDAO();
		List<Map<String,Object>> list=dao.getSp(types);	
//		System.out.println("1"+list);
		request.setAttribute("list", list);
		request.getRequestDispatcher("listwbs.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
