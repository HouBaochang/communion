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

public class TeacherRlistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session=request.getSession();
		String tname=(String)session.getAttribute("tname");
		String answer=(String)session.getAttribute("answer");
		System.out.println(tname);
		BaseDAO dao= new BaseDAO();
		List<Map<String,Object>> list=dao.getTeacherRlisr(tname);
	
		System.out.println(answer);
//		System.out.println("1"+list);
		response.setContentType("text/html;charset=utf-8");
		request.setAttribute("list", list);
//		System.out.print(sno);
		request.getRequestDispatcher("tearely.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	
	}
}
