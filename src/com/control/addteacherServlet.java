package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BaseDAO;

public class addteacherServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String tno=request.getParameter("tno");
		 int tn= Integer.parseInt(tno);
		String tpsw=request.getParameter("tpsw");
		String tname=request.getParameter("tname");
		 String Tname=new String(tname.getBytes("iso-8859-1"),"utf-8");
		BaseDAO dao=new BaseDAO();
		boolean status=dao.addteacher(tno,tpsw,Tname);
		PrintWriter out = response.getWriter();
		if(status==true){
			out.println("1");
		}
		else{
			out.println("0");
		}
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
